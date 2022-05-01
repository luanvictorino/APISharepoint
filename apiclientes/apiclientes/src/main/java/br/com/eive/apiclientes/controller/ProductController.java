package br.com.eive.apiclientes.controller;

import br.com.eive.apiclientes.model.Product;
import br.com.eive.apiclientes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/product"})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List findAll(){
        return productRepository.findAll();
    }

    @GetMapping(path = {"customer/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return productRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    @Transactional
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Product product){
        return productRepository.findById(id)
                .map(record -> {
                    record.setName(product.getName());
                    record.setNotes(product.getNotes());
                    record.setAcquisitionDate(product.getAcquisitionDate());
                    Product updated = productRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return productRepository.findById(id)
                .map(record -> {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
