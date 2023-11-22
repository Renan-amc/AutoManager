package Concecionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*Importação de entidades e repositorios*/
import Concecionaria.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private Concecionaria.repository.ClienteRepository cliente_repository;

	/* Puxa todos os clientes obtidos na lista */
	@GetMapping
	public List<Cliente> listar() {
		return cliente_repository.findAll();
	}

	/* Puxa os dados do cliente pelo seu ID */
	@GetMapping("/{id}")
	private Cliente listar(@PathVariable Long id) {
		Cliente clienteExistente = cliente_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
		return clienteExistente;
	}

	/* Insere objetos clientes */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Cliente adicionar(@RequestBody Cliente cliente) {
		return cliente_repository.save(cliente);
	}

	/* Atualiza objetos clientes chamando pelo numero do seu ID */
	@PutMapping("/{id}")
	private Cliente atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		Cliente clienteExistente = cliente_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		clienteExistente.setNome(clienteAtualizado.getNome());
		clienteExistente.setCpf(clienteAtualizado.getCpf());
		clienteExistente.setIdade(clienteAtualizado.getIdade());
		clienteExistente.setCarro(clienteAtualizado.getCarro());

		return cliente_repository.save(clienteExistente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		Cliente clienteExistente = cliente_repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

		String nomeCliente = clienteExistente.getNome(); // Obtém o nome do cliente antes de deletar

		cliente_repository.delete(clienteExistente);

		System.out.println("Cliente deletado - Id: " + id + ", Nome: " + nomeCliente);
	}

}
