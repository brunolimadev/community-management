package br.com.fiap.communitymanagement.controller;


import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.service.AprovacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/community-management/approve")
public class AprovacaoController {
    @Autowired
    private AprovacaoService aprovacaoService;

    @PostMapping()
    public ResponseEntity<AprovacaoDto> save(@RequestBody AprovacaoDto aprovacaoDto) {
        return ResponseEntity.status(201).body(aprovacaoService.save(aprovacaoDto));
    }
}