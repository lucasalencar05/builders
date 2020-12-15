package com.builders.services;

import com.builders.domain.Cliente;
import com.builders.exceptions.ObjectNotFoundException;
import com.builders.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente find(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "+ Cliente.class.getName()));
    }

    public Optional<Cliente> findById(Long id) {
        Optional<Cliente> obj = repository.findById(id) ;
        return obj;
    }

    public Page<Cliente> findAll(Pageable pageable) {
        Page<Cliente> page = repository.findAll(pageable);
        return page;
    }

    public Cliente save(Cliente obj) {
        return repository.save(obj);
    }

    public Cliente update(Long id, Cliente obj) {
        Cliente clienteSave = find(id);

        BeanUtils.copyProperties(obj, clienteSave, "id");
        return repository.save(clienteSave);
    }

    public Cliente findByCpf(String cpf) {
        Cliente obj = repository.findByCpf(cpf);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + obj.getId()
                    + ", Tipo: " + Cliente.class.getName());
        }
        return obj;
    }

    public List<Cliente> findByNomeIgnoreCaseContaining(String nome) {
        List<Cliente> obj = repository.findByNomeIgnoreCaseContaining(nome);
        return obj;
    }

    public void delete(Long id) {
       repository.deleteById(id);
    }

}
