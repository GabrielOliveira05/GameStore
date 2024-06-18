package com.game.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = false, length = 200)
	private String plataforma;
	
	@Column(nullable = false, length = 500)
	private String descricao;
	
	@Column(nullable = true)
	private LocalDate lancamento;
	
	
	@Column(nullable = true, precision = 20, scale = 2)
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genero genero;

}
