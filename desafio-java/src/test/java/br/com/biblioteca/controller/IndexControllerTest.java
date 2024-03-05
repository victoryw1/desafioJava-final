package br.com.biblioteca.controller;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @InjectMocks
    private IndexController controller;

    @Mock
    private Model model;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void home(){
        var redirect = controller.home(model, httpServletRequest);
        assertEquals("index", redirect);
    }
    
}
