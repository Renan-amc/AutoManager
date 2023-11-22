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
import org.springframework.http.HttpStatus;

import Concecionaria.entities.Concessionaria;
import Concecionaria.repository.ConcessionariaRepository;

@RestController
@RequestMapping("/concessionarias")
public class ConcessionariaController {

    @Autowired
    private ConcessionariaRepository concessionaria_repository;

    @GetMapping
	public List<Concessionaria> listar() {
		return concessionaria_repository.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Concessionaria adicionar(@RequestBody Concessionaria concessionaria) {
		return concessionaria_repository.save(concessionaria);
	}

	@PutMapping("/{id}")
	private Concessionaria atualizar(@PathVariable Long id, @RequestBody Concessionaria concessionariaAtualizado) {
		Concessionaria concessionariaExistente = concessionaria_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Concessionaria não encontrado"));

		concessionariaExistente.setProprietario(concessionariaAtualizado.getProprietario());
		concessionariaExistente.setCarros(concessionariaAtualizado.getCarros());
		concessionariaExistente.setNome(concessionariaAtualizado.getNome());

		return concessionaria_repository.save(concessionariaExistente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		Concessionaria concessionariaExistente = concessionaria_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Concessionaria não encontrado!"));

		String nomeProprietario = concessionariaExistente.getProprietario(); // Obtém o nome do cliente antes de deletar

		concessionaria_repository.delete(concessionariaExistente);

		System.out.println("Concessionaria deletada - Id: " + id + ", Nome: " + nomeProprietario);
	}
}

