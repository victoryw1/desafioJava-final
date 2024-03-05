package br.com.biblioteca.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.model.dto.PessoaDTO;
import br.com.biblioteca.model.mapper.PessoaMapper;
import br.com.biblioteca.service.PessoaService;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {
    
    @InjectMocks
    private PessoaController controller;

    @Mock
    private PessoaService service;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private ModelMap modelMap;

    @Test
    public void adicionar() {
        when(service.getMapper()).thenReturn(PessoaMapper.INSTANCE);

        var response = controller.adicionar(mock(PessoaDTO.class));

        verify(service ,times(1)).adicionar(any(PessoaDTO.class));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
