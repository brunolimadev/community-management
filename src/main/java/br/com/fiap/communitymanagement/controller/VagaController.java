package br.com.fiap.communitymanagement.controller;

import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.entitie.VagaEntity;
import br.com.fiap.communitymanagement.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community-management")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @RequestMapping("/vacancy")
    @PostMapping()
    public ResponseEntity<VagaDto> save(@RequestBody VagaDto vaga) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(vagaService.save(vaga));
    }
}