package br.com.biblioteca.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.biblioteca.model.dto.MembroDTO;
import br.com.biblioteca.model.mapper.MembroMapper;
import br.com.biblioteca.service.MembroService;

@ExtendWith(MockitoExtension.class)
class MembroControllerTest {

    @InjectMocks
    private MembroController controller;

    @Mock
    private MembroService membroService;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private ModelMap modelMap;

    @BeforeEach
    public void before() {
        when(membroService.getMapper()).thenReturn(MembroMapper.INSTANCE);
    }

    @Test
    void adicionar() {
        var redirect = controller.adicionar(mock(MembroDTO.class), bindingResult, redirectAttributes, modelMap);

        assertEquals("redirect:/projeto/listar",redirect);
    }
    
}
