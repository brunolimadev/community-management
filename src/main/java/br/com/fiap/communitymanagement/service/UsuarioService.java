package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.UsuarioDto;
import br.com.fiap.communitymanagement.entities.UsuarioEntity;
import br.com.fiap.communitymanagement.enumerator.TipoUsuarioEnum;
import br.com.fiap.communitymanagement.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public void mock() {
        salvarUsuarioTipoAdministrador();
        salvarUsuarioTipoMorador();
        salvarUsuarioTipoInquelino();
    }

    private void salvarUsuarioTipoMorador() {
        repository.save(criarUsuario(new UsuarioDto("Sogarn", "sogarn@gmail.com", "864.134.480-24", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Gilrion", "gilrion@outlook.com", "180.797.430-88", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Danuel", "danuel@yahoo.com", "084.733.520-84", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Maunr", "maunr@uol.com.br", "597.476.780-20", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Baewar", "baewar@outlook.com", "163.216.000-59", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Haunrak", "haunrak@gmail.com", "970.027.800-00", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Usladak", "usladak@bol.com.br", "207.429.340-20", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Sopli", "sopli.@gmail.com", "587.968.560-84", TipoUsuarioEnum.MORADOR.name(), UUID.randomUUID())));
    }

    private void salvarUsuarioTipoInquelino() {
        repository.save(criarUsuario(new UsuarioDto("Dolarz", "dolarz@uol.com.br", "775.229.140-43", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Boihuce", "boihuce@yahoo.com", "026.427.470-93", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Alauk", "alauk@hotmail.com", "771.644.480-86", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Fuihi", "fuihi@hotmail.com", "418.702.590-17", TipoUsuarioEnum.INQUELINO.name(), UUID.randomUUID())));
    }

    private void salvarUsuarioTipoAdministrador() {
        repository.save(criarUsuario(new UsuarioDto("Nuata", "nuata@gmail.com", "855.936.980-58", TipoUsuarioEnum.ADMINISTRADOR.name(), UUID.randomUUID())));
        repository.save(criarUsuario(new UsuarioDto("Vyoinit", "vyoinit@outook.com", "329.194.510-73", TipoUsuarioEnum.ADMINISTRADOR.name(), UUID.randomUUID())));
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

}