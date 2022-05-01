package br.com.eive.apiclientes.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 4000)
    private String notes;

    @Column(length = 4000)
    private String dbInfo;

    @Column(nullable = false)
    private Boolean usesVpn;

    private Boolean usesNewIntegration;

    @Column(nullable = false, length = 1)
    private String tier;

    @Column(length = 36)
    private String segment;

    @Column(nullable = false, length = 80)
    private String responsible;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Server> server = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Product> products = new ArrayList<>();

    public Customer(){
    }

    public Customer(String name, String notes, String dbInfo, Boolean usesVpn, Boolean usesNewIntegration,
                    String tier, String segment, String responsible) {
        this.name = name;
        this.notes = notes;
        this.dbInfo = dbInfo;
        this.usesVpn = usesVpn;
        this.usesNewIntegration = usesNewIntegration;
        this.tier = tier;
        this.segment = segment;
        this.responsible = responsible;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer that = (Customer) obj;
        return Objects.equals(id, that.id);
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

    public String getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(String dbInfo) {
        this.dbInfo = dbInfo;
    }

    public Boolean getUsesVpn() {
        return usesVpn;
    }

    public void setUsesVpn(Boolean usesVpn) {
        this.usesVpn = usesVpn;
    }

    public Boolean getUsesNewIntegration() {
        return usesNewIntegration;
    }

    public void setUsesNewIntegration(Boolean usesNewIntegration) {
        this.usesNewIntegration = usesNewIntegration;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setServer(List<Server> server) {
        this.server = server;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
