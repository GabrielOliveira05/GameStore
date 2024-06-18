package com.game.store.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.store.model.Jogo;
import com.game.store.repository.JogoRepository;

@RestController
@RequestMapping("/gamestore")
public class JogoController {

	@Autowired
	JogoRepository jogoRepository;

	@PostMapping
	public ResponseEntity<Jogo> salvar(@RequestBody Jogo jogo) {

		Jogo jogoSalvo = jogoRepository.save(jogo);
		return ResponseEntity.ok(jogoSalvo);
	}

	@GetMapping("/buscarid/{id}")
	public ResponseEntity<Jogo> getJogoById(Long id) {

		Optional<Jogo> jogo = jogoRepository.findById(id);

		if (jogo.isEmpty()) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(jogo.get());
	}

	@DeleteMapping("/deleteid/{id}")
	public ResponseEntity<Jogo> deleteById(@PathVariable Long id) {
		Optional<Jogo> jogo = jogoRepository.findById(id);

		if (jogo.isPresent()) {
			jogoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {

		Optional<Jogo> findById = jogoRepository.findById(id);
		findById.map(jogoExistente -> {
			jogo.setId(jogoExistente.getId());
			jogoRepository.save(jogo);
			return ResponseEntity.noContent().build();
		});
		return ResponseEntity.ok(jogo);
		
	}

}
