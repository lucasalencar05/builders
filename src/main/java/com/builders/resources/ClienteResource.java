package com.builders.resources;

import com.builders.domain.Cliente;
import com.builders.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<?> getAll(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Cliente> obj = clienteService.findAll(pageable);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> findClientById(@PathVariable Long id) {
        Cliente obj = clienteService.find(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cliente save(@Valid @RequestBody Cliente obj) {
        return clienteService.save(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Cliente clienteSave = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteSave);
    }

    @RequestMapping(path = "/nome/{nome}", method = RequestMethod.GET)
    public List<Cliente> findByNomeIgnoreCaseContaining(@PathVariable String nome) {
        List<Cliente> obj = clienteService.findByNomeIgnoreCaseContaining(nome);
        return obj;
    }

    @RequestMapping(value="cpf/{cpf}", method=RequestMethod.GET)
    public Cliente findByCpf(@PathVariable String cpf) {
        Cliente obj = clienteService.findByCpf(cpf);
        return obj;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        clienteService.delete(id);
    }


}
