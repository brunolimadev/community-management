package br.com.fiap.communitymanagement.controller;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community-management/rent")
public class LocacaoController {
    @Autowired
    private LocacaoService locacaoService;

    @PostMapping()
    public ResponseEntity<LocacaoDto> save(@RequestBody LocacaoDto locacaoDto) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(locacaoService.save(locacaoDto));
    }
}