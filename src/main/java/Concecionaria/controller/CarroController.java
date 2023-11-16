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

import Concecionaria.entities.Carro;
import Concecionaria.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository carrorepository;

	@GetMapping("/all")
	public List<Carro> listar() {
		return carrorepository.findAll();
	}

	/* Puxa os dados do cliente pelo seu ID */
	@GetMapping("/{id}")
	private Carro listar(@PathVariable Long id) {
		Carro carroExistente = carrorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Carro não encontrado"));
		return carroExistente;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Carro adicionar(@RequestBody Carro carro) {
		return carrorepository.save(carro);
	}

	@PutMapping("/{id}") // caminho chamado: "/carros/id(numero selecionado)"
	// PathVariable para casar o id posto pelo usuario no id do parametro.
	private Carro atualizar(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
		Carro carroExistente = carrorepository.findById(id)
				// pelo id que selecionei ele busca o carro com este id correspondente
				.orElseThrow(() -> new RuntimeException("Carro não encontrado"));
		// tratamento de eror caso o carro nâo seja encontrado.

		carroExistente.setMarca(carroAtualizado.getMarca());
		carroExistente.setModelo(carroAtualizado.getModelo());
		carroExistente.setAno(carroAtualizado.getAno());
		carroExistente.setCor(carroAtualizado.getCor());

		return carrorepository.save(carroExistente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		Carro carroExistente = carrorepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Carro não encontrado!"));

		String modeloCarro = carroExistente.getModelo();

		carrorepository.delete(carroExistente);
		System.out.println("Cliente deletado - Id: " + id + ", Nome: " + modeloCarro);
	}
}
