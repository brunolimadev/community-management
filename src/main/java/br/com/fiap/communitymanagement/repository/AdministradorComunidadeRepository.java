package br.com.fiap.communitymanagement.repository;

import br.com.fiap.communitymanagement.entities.AdministradorComunidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdministradorComunidadeRepository extends JpaRepository<AdministradorComunidadeEntity, UUID> { }