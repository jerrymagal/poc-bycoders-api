package br.com.bycoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bycoders.entities.Cnab;

@Repository
public interface CnabRepository extends JpaRepository<Cnab, Integer> {
}
