package br.com.biblioteca.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.biblioteca.repository.ProjetoRepository;

@ExtendWith(MockitoExtension.class)
public class ProjetoServiceTest {
    
    @InjectMocks
    private ProjetoService service;

    @Mock
    private ProjetoRepository repository;


    @BeforeEach
    public void before() {}

    @Test
    public void getRepository() {
        assertNotNull(service.getRepository());
    }

    @Test
    public void getMapper() {
        assertNotNull(service.getMapper());
    }
}
