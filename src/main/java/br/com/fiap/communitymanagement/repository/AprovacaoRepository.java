package br.com.fiap.communitymanagement.repository;

import br.com.fiap.communitymanagement.entities.AprovacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AprovacaoRepository extends JpaRepository<AprovacaoEntity, UUID> { }