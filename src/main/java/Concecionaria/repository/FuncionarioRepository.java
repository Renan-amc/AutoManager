package Concecionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Concecionaria.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
