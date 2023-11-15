package Concecionaria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carro")
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;
	
	@ManyToOne
	@JoinColumn(name = "concecionaria_id")
	private Concecionaria concecionaria;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}
