package br.com.fiap.communitymanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.service.AprovacaoService;

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