package br.com.fiap.communitymanagement.controller;


import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.service.AprovacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/community-management/aprove")
public class AprovacaoController {
    @Autowired
    private AprovacaoService aprovacaoService;

    @PostMapping("{vagaId}")
    public ResponseEntity<AprovacaoDto> save(@RequestBody AprovacaoDto aprovacaoDto, @PathVariable UUID vagaId) {
        return ResponseEntity.status(201).body(aprovacaoService.save(aprovacaoDto));
    }
}