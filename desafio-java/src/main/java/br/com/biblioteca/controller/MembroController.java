package br.com.biblioteca.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.service.MembroService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/membro")
public class MembroController {

    private final MembroService membroService;

    @PostMapping("/adicionar")
    public String adicionar(@Valid @ModelAttribute("membro") MembroDTO membro, BindingResult result, RedirectAttributes redirectAttributes, ModelMap model) {

        var savedMembro = membroService.getMapper().parseEntityToDTO(membroService.adicionar(membro));
        redirectAttributes.addFlashAttribute("savedMembro", savedMembro);
        redirectAttributes.addFlashAttribute("addMembroSuccess", true);
        return "redirect:/projeto/listar"; 
    }
    
}
