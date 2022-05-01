package br.com.eive.apiclientes.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String notes;
    public String acquisitionDate;

    @ManyToOne(optional = false)
    private Customer customer;

    public Product(){
    }

    public Product(Long id, String name, String notes, String acquisitionDate) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.acquisitionDate = acquisitionDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
