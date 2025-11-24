package com.lucianodev.ds_crud_desafio.services;

import com.lucianodev.ds_crud_desafio.dto.ClientDTO;
import com.lucianodev.ds_crud_desafio.entities.Client;
import com.lucianodev.ds_crud_desafio.repositories.ClientRepository;
import com.lucianodev.ds_crud_desafio.services.exceptions.DataBaseException;
import com.lucianodev.ds_crud_desafio.services.exceptions.ResourceNotFoundException;
import com.lucianodev.ds_crud_desafio.services.exceptions.UniqueCpfViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClientService {

    @Autowired
    private ClientRepository repository;


    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDTOToEntity(dto, entity);

        try {
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (DataIntegrityViolationException e) {
            Throwable root = e.getRootCause();

            if (root != null && root.getMessage() != null && root.getMessage().toUpperCase().contains("CPF")) {
                throw new UniqueCpfViolationException("O CPF " + dto.getCpf() + " já está cadastrado");
            }
            throw new DataBaseException("Falha de integridade de dados" + root.getMessage());
        }
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            copyDTOToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            Throwable root = e.getRootCause();
            if (root != null && root.getMessage() != null && root.getMessage().toUpperCase().contains("CPF")) {
                throw new UniqueCpfViolationException("O CPF " + dto.getCpf() + " já está em uso");
            }
            throw new DataBaseException("Falha de integridade de dados: " + root.getMessage());
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade referencial");
        }
    }

    public void copyDTOToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
