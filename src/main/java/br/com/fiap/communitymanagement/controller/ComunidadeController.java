package br.com.fiap.communitymanagement.controller;

import br.com.fiap.communitymanagement.dto.ComunidadeDto;
import br.com.fiap.communitymanagement.service.ComunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community-management/communities")
public class ComunidadeController {
    @Autowired
    private ComunidadeService comunidadeService;

    @GetMapping
    public ResponseEntity<Page<ComunidadeDto>> findAllCommunities(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {
        comunidadeService.mock();
        Page<ComunidadeDto> comunidadeDtoPage = comunidadeService.findAll(pageable);
        return ResponseEntity.ok(comunidadeDtoPage);
    }
}