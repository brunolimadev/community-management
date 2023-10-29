package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.UsuarioDto;
import br.com.fiap.communitymanagement.entities.UsuarioEntity;
import br.com.fiap.communitymanagement.enumerator.TipoUsuarioEnum;
import br.com.fiap.communitymanagement.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void mock() {
        salvarUsuarioTipoAdministrador();
        salvarUsuarioTipoMorador();
        salvarUsuarioTipoInquelino();
    }

    public Page<UsuarioDto> findAll(Pageable pageable) {
        Page<UsuarioEntity> usuarioEntityPage = usuarioRepository.findAll(pageable);
        return usuarioEntityPage.map(this::toUsuarioDto);
    }

    private void salvarUsuarioTipoMorador() {
        usuarioRepository.save(criarUsuario(new UsuarioDto(null,"Sogarn", "sogarn@gmail.com", "864.134.480-24", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null,"Gilrion", "gilrion@outlook.com", "180.797.430-88", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null,"Danuel", "danuel@yahoo.com", "084.733.520-84", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null,"Maunr", "maunr@uol.com.br", "597.476.780-20", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Baewar", "baewar@outlook.com", "163.216.000-59", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Haunrak", "haunrak@gmail.com", "970.027.800-00", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Usladak", "usladak@bol.com.br", "207.429.340-20", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Sopli", "sopli.@gmail.com", "587.968.560-84", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
    }

    private void salvarUsuarioTipoInquelino() {
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Dolarz", "dolarz@uol.com.br", "775.229.140-43", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Boihuce", "boihuce@yahoo.com", "026.427.470-93", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Alauk", "alauk@hotmail.com", "771.644.480-86", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Fuihi", "fuihi@hotmail.com", "418.702.590-17", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
    }

    private void salvarUsuarioTipoAdministrador() {
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Nuata", "nuata@gmail.com", "855.936.980-58", TipoUsuarioEnum.ADMINISTRADOR.name(), UUID.randomUUID())));
        usuarioRepository.save(criarUsuario(new UsuarioDto(null, "Vyoinit", "vyoinit@outook.com", "329.194.510-73", TipoUsuarioEnum.ADMINISTRADOR.name(), UUID.randomUUID())));
    }

    private UsuarioEntity criarUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setCpf(usuarioDto.cpf());
        usuarioEntity.setNome(usuarioDto.nome());
        usuarioEntity.setEmail(usuarioDto.email());
        usuarioEntity.setTipoUsuario(usuarioDto.tipoUsuario());
        usuarioEntity.setComunidadeId(usuarioDto.comunidadeId());
        return usuarioEntity;
    }

    private UsuarioDto toUsuarioDto(UsuarioEntity usuarioEntity) {
        return new UsuarioDto(usuarioEntity.getId(),
                usuarioEntity.getNome(),
                usuarioEntity.getEmail(),
                usuarioEntity.getCpf(),
                usuarioEntity.getTipoUsuario(),
                usuarioEntity.getComunidadeId());
    }

}