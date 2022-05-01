package br.com.eive.apiclientes.controller;

import br.com.eive.apiclientes.model.Contact;
import br.com.eive.apiclientes.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/contact"})
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List findAll(){
        return contactRepository.findAll();
    }

    @GetMapping(path = {"customer/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return contactRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    @Transactional
    public Contact create(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Contact contact){
        return contactRepository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    record.setCellphone(contact.getCellphone());
                    record.setMain(contact.getMain());
                    Contact updated = contactRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return contactRepository.findById(id)
                .map(record -> {
                    contactRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
