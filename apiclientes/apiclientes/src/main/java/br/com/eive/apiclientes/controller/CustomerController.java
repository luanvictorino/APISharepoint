package br.com.eive.apiclientes.controller;

import br.com.eive.apiclientes.model.Customer;
import br.com.eive.apiclientes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/customer"})
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List findAll(){
        return customerRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return customerRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    @Transactional
    public Customer create(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Customer customer){
        return customerRepository.findById(id)
                .map(record -> {
                    record.setName(customer.getName());
                    record.setNotes(customer.getNotes());
                    record.setDbInfo(customer.getDbInfo());
                    record.setUsesVpn(customer.getUsesVpn());
                    record.setUsesNewIntegration(customer.getUsesNewIntegration());
                    record.setTier(customer.getTier());
                    record.setSegment(customer.getSegment());
                    record.setResponsible(customer.getResponsible());
                    Customer updated = customerRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return customerRepository.findById(id)
                .map(record -> {
                    customerRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
