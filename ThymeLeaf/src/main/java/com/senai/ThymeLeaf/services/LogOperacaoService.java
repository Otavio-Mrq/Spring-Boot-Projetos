package com.senai.ThymeLeaf.services;

import com.senai.ThymeLeaf.dtos.LogOperacao;
import com.senai.ThymeLeaf.models.ContatoModel;
import com.senai.ThymeLeaf.models.UsuarioModel;
import com.senai.ThymeLeaf.models.estadoModel;
import com.senai.ThymeLeaf.models.municipioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.query.AuditEntity;

@Service
public class LogOperacaoService {
    
     @PersistenceContext
    private EntityManager entityManager;

    public List<LogOperacao> obterRevisoes() {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Consulta as revisões de todas as entidades auditadas
        List<LogOperacao> auditorias = new ArrayList<>();

        auditorias.addAll(obterRevisoesPorEntidade(auditReader, UsuarioModel.class, "Usuario"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, municipioModel.class, "Municipio"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, ContatoModel.class, "Contato"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, estadoModel.class, "Estado"));

        return auditorias;
    }

    // Método para buscar as revisões de uma entidade específica
    private List<LogOperacao> obterRevisoesPorEntidade(AuditReader auditReader, Class<?> entidade, String nomeEntidade) {
        // Busca as revisões da entidade
        List<Object[]> results = auditReader.createQuery()
                .forRevisionsOfEntity(entidade, false, true)
                .addOrder(AuditEntity.revisionProperty("id").desc())
                .getResultList();

        // Converte as revisões para o DTO
        return results.stream().map(revision -> {
            Object entidadeObj = revision[0];
            DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) revision[1];
            RevisionType revisionType = (RevisionType) revision[2];

            // Converte o timestamp de revisão para LocalDateTime
            LocalDateTime dataHora = Instant.ofEpochMilli(revisionEntity.getTimestamp())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Converte o RevisionType para String
            String operacao;
            switch (revisionType) {
                case ADD:
                    operacao = "CREATE";
                    break;
                case MOD:
                    operacao = "UPDATE";
                    break;
                case DEL:
                    operacao = "DELETE";
                    break;
                default:
                    operacao = "UNKNOWN";
            }

            // Cria o DTO
            LogOperacao dto = new LogOperacao();
            if (entidadeObj instanceof UsuarioModel) {
                UsuarioModel usuario = (UsuarioModel) entidadeObj;
                dto.setId(usuario.getId());
                dto.setUsuario(usuario.getEmail());
            } else if (entidadeObj instanceof municipioModel) {
                municipioModel municipio = (municipioModel) entidadeObj;
                dto.setId(municipio.getId());
                dto.setUsuario(municipio.getNome()); // Assume que a entidade MunicipioModels tem esse campo
            } else if (entidadeObj instanceof ContatoModel) {
                ContatoModel contato = (ContatoModel) entidadeObj;
                dto.setId(contato.getId());
                dto.setUsuario(contato.getNome()); // Assume que a entidade ContatoModels tem esse campo
            } else if (entidadeObj instanceof estadoModel) {
                estadoModel estado = (estadoModel) entidadeObj;
                dto.setId(estado.getId());
                dto.setUsuario(estado.getNome()); // Assume que a entidade EstadoModels tem esse campo
            }

            dto.setEntidade(nomeEntidade);
            dto.setOperacao(operacao);
            dto.setDataHora(dataHora);

            return dto;
        }).collect(Collectors.toList());
    }
}
