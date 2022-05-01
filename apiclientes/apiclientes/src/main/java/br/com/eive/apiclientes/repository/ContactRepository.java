package br.com.eive.apiclientes.repository;

import br.com.eive.apiclientes.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
