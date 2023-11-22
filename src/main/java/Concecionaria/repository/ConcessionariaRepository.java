package Concecionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Concecionaria.entities.Concessionaria;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {

}
