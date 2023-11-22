package Concecionaria.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Concecionaria.entities.Funcionario;
import Concecionaria.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController{
    @Autowired
    private FuncionarioRepository funcionario_repository;

    @GetMapping
    private List<Funcionario> listar(){
        return funcionario_repository.findAll();
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Funcionario adicionar(@RequestBody Funcionario funcionario) {
		return funcionario_repository.save(funcionario);
	}

    @PutMapping("/{id}")
	private Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
		Funcionario funcionarioExistente = funcionario_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

		funcionarioExistente.setNome(funcionarioAtualizado.getNome());
		funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
        funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
        funcionarioExistente.setConcecionaria(funcionarioAtualizado.getConcecionaria());

		return funcionario_repository.save(funcionarioExistente);
	}


    @DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		Funcionario funcionarioExistente = funcionario_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));

		String nomeFuncioanrio = funcionarioExistente.getNome(); // Obtém o nome do cliente antes de deletar

		funcionario_repository.delete(funcionarioExistente);

		System.out.println("Funcionario deletado - Id: " + id + ", Nome: " + nomeFuncioanrio);
	}
    
}
