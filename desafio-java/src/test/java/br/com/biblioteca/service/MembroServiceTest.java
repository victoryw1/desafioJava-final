package br.com.biblioteca.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.biblioteca.repository.MembroRepository;

@ExtendWith(MockitoExtension.class)
class MembroServiceTest {

    @InjectMocks
    private MembroService service;

    @Mock
    private MembroRepository repository;


    @BeforeEach
    public void before() {}

    @Test
    void getRepository() {
        assertNotNull(service.getRepository());
    }

    @Test
    void getMapper() {
        assertNotNull(service.getMapper());
    }
    
}
