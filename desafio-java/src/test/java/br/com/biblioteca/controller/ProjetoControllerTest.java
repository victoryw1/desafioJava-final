package br.com.biblioteca.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.dto.ProjetoDTO;
import br.com.biblioteca.model.entity.Projeto;
import br.com.biblioteca.model.mapper.ProjetoMapper;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;

@ExtendWith(MockitoExtension.class)
public class ProjetoControllerTest {

    @InjectMocks
    private ProjetoController controller;

    @Mock
    private ProjetoService service;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private ModelMap modelMap;

    @BeforeEach
    public void before() {
        when(service.getMapper()).thenReturn(ProjetoMapper.INSTANCE);
    }

    @Test
    public void lista() {
        var redirect = controller.lista(model);
        verify(service ,times(1)).findAll();
        assertTrue(!redirect.isEmpty());
    }

    @Test
    public void adicionar() {
        var redirect = controller.adicionar(mock(ProjetoDTO.class), bindingResult, redirectAttributes, modelMap);

        assertEquals("redirect:/projeto/listar",redirect);
    }

    @Test
    public void adicionarErro() {

        when(bindingResult.hasErrors()).thenReturn(true);

        var redirect = controller.adicionar(mock(ProjetoDTO.class), bindingResult, redirectAttributes, modelMap);

        assertEquals("adicionar-projeto",redirect);
    }

    @Test
    public void telaAdd(){
        var redirect = controller.addEdit(0L, model);
        assertEquals("adicionar-projeto",redirect);
    }

    @Test
    public void telaEdit(){
        var redirect = controller.addEdit(1L, model);
        assertTrue(!redirect.isEmpty());
    }
    

    @Test
    public void delete(){
        when(service.findById(anyLong())).thenReturn(mock(Projeto.class));
        controller.delete(1L, redirectAttributes);

        verify(service ,times(1)).delete(anyLong());
    }


    @Test
    public void naoDelete(){
        when(service.findById(anyLong())).thenReturn(Projeto.builder().status(StatusEnum.INICIADO).build());
        controller.delete(1L, redirectAttributes);

        verify(service ,times(0)).delete(anyLong());
    }

}
