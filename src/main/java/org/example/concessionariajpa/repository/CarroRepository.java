package org.example.concessionariajpa.repository;

import org.example.concessionariajpa.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByMarcaContainingIgnoreCase(String marca);
    List<Carro> findByAnoContainingIgnoreCase(Integer ano);
    List<Carro> findByPrecoLessThan(Double preco);
}
