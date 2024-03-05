package br.com.biblioteca.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.biblioteca.repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository repository;


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

    @Test
    public void listarFuncionarios() {
        var list = service.listarFuncionarios();

        assertTrue(list.isEmpty());
    }
}
