package br.com.biblioteca.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.model.dto.PessoaDTO;
import br.com.biblioteca.service.PessoaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaDTO> adicionar(@RequestBody @Valid PessoaDTO dto) {

        var entity = service.adicionar(dto);
		
		return ResponseEntity.ok(service.getMapper().parseEntityToDTO(entity));
    }
}