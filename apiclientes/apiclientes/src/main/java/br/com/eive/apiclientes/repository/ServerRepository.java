package br.com.eive.apiclientes.repository;

import br.com.eive.apiclientes.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
}
