package br.com.eive.apiclientes.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ip;

    private String dns;

    private String login;

    private String password;

    @Column(nullable = false)
    private String name;

    private String notes;

    @ManyToOne(optional = false)
    private Customer customer;

    public Server() {
    }

    public Server(Long id, String ip, String dns, String login, String password, String names, String notes, Customer customer) {
        this.id = id;
        this.ip = ip;
        this.dns = dns;
        this.login = login;
        this.password = password;
        this.name = names;
        this.notes = notes;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Server server = (Server) obj;
        return Objects.equals(id, server.id);
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setIdCustomer(Long id){
        this.customer.setId(id);
    }
}
