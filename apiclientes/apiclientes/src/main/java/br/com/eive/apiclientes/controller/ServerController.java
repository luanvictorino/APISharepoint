package br.com.eive.apiclientes.controller;

import br.com.eive.apiclientes.model.Server;
import br.com.eive.apiclientes.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/server"})
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping
    public List findAll(){
        return serverRepository.findAll();
    }

    @GetMapping(path = {"customer/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return serverRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    @Transactional
    public Server create(@RequestBody Server server){
        return serverRepository.save(server);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Server server){
        return serverRepository.findById(id)
                .map(record -> {
                    record.setIp(server.getIp());
                    record.setDns(server.getDns());
                    record.setLogin(server.getLogin());
                    record.setPassword(server.getPassword());
                    record.setName(server.getName());
                    record.setNotes(server.getNotes());
                    Server updated = serverRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return serverRepository.findById(id)
                .map(record -> {
                    serverRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
