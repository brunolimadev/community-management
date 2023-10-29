package br.com.fiap.communitymanagement.controller;

import br.com.fiap.communitymanagement.dto.ComunidadeDto;
import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.service.ComunidadeService;
import br.com.fiap.communitymanagement.service.LocacaoService;
import br.com.fiap.communitymanagement.service.UsuarioService;
import br.com.fiap.communitymanagement.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/community-management")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComunidadeService comunidadeService;

    @Autowired
    private LocacaoService locacaoService;

    @RequestMapping("/vacancy")
    @PostMapping()
    public ResponseEntity<VagaDto> save(@RequestBody VagaDto vaga) {
        usuarioService.mock();
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(vagaService.save(vaga));
    }

    @RequestMapping("/rent")
    @PostMapping()
    public ResponseEntity<LocacaoDto> save(@RequestBody LocacaoDto locacaoDto) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(locacaoService.save(locacaoDto));
    }

    @RequestMapping("/communities")
    @GetMapping
    public ResponseEntity<Page<ComunidadeDto>> findAllCommunities(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {
        comunidadeService.mock();
        Page<ComunidadeDto> comunidadeDtoPage = comunidadeService.findAll(pageable);
        return ResponseEntity.ok(comunidadeDtoPage);
    }

    @GetMapping
    public ResponseEntity<Page<VagaDto>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "description") Pageable pageable) {
        Page<VagaDto> vagaDTO = vagaService.findAll(pageable);
        return ResponseEntity.ok(vagaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaDto> findById(@PathVariable UUID id) {
        VagaDto VagaDto = vagaService.findById(id);
        return ResponseEntity.ok(VagaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaDto> update(@PathVariable UUID id, @RequestBody VagaDto VagaDto) {
        VagaDto vagaDTO = vagaService.update(id, VagaDto);
        return ResponseEntity.ok(vagaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        vagaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}