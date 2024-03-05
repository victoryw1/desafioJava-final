package br.com.biblioteca.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service;
    private final PessoaService pessoaService;

    @GetMapping("/listar")
    public String lista(Model model) {
        model.addAttribute("listProjeto",  service.getMapper().listEntityToListDTO(service.findAll()));
        return "listar-projeto";
    }

    @PostMapping("/adicionar")
    public String adicionar(@Valid @ModelAttribute("projeto") ProjetoDTO projeto, BindingResult result, RedirectAttributes redirectAttributes, ModelMap model) {

        if (result.hasErrors()) {
            service.getMapper().parseDTOToEntity(projeto);
            model.addAttribute("listStatus", StatusEnum.values());
            model.addAttribute("listRisco", RiscoEnum.values());
            model.addAttribute("listGerente", pessoaService.listarGerentes());
            model.addAttribute("listFuncionario", pessoaService.listarFuncionarios());

            return "adicionar-projeto";
            // return "redirect:/projeto/"+projeto.getId();
        }

        var savedProjeto = service.getMapper().parseEntityToDTO(service.adicionar(projeto));
        redirectAttributes.addFlashAttribute("savedProjeto", savedProjeto);
        redirectAttributes.addFlashAttribute("addProjetoSuccess", true);
        return "redirect:/projeto/listar"; 
    }

    @GetMapping(value="/{id}")
    public String addEdit(@PathVariable Long id, Model model){
        var projeto =  id.equals(0L) ? new Projeto():service.findById(id);

        model.addAttribute("projeto", service.getMapper().parseEntityToDTO(projeto));
        model.addAttribute("listStatus", StatusEnum.values());
        model.addAttribute("listRisco", RiscoEnum.values());
        model.addAttribute("listGerente", pessoaService.listarGerentes());
        model.addAttribute("listFuncionario", pessoaService.listarFuncionarios());

        return "adicionar-projeto";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        var status =service.getMapper().parseEntityToDTO(service.findById(id)).getStatus();
        if(!Arrays.asList(StatusEnum.INICIADO,StatusEnum.EM_ANDAMENTO,StatusEnum.ENCERRADO).contains(status)){
            service.delete(id);
        }else {
            redirectAttributes.addFlashAttribute("deleteProjeto", true);
            redirectAttributes.addFlashAttribute("statusProjeto", status.getLabel());
        }

        return "redirect:/projeto/listar";
    }
}
