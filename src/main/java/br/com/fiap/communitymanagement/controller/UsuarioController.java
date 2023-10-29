package br.com.fiap.communitymanagement.controller;

import br.com.fiap.communitymanagement.dto.UsuarioDto;
import br.com.fiap.communitymanagement.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community-management/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> findAllCommunities(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {
        usuarioService.mock();
        Page<UsuarioDto> usuarioDtoPage = usuarioService.findAll(pageable);
        return ResponseEntity.ok(usuarioDtoPage);
    }
}