package com.devsagi.photoGrid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsagi.photoGrid.model.Polaroid;
import com.devsagi.photoGrid.repository.PolaroidRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/polaroids")
public class PolaroidController {
	
	private PolaroidRepository repository;
	public PolaroidController(PolaroidRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Flux<Polaroid> getAllPolaroids(){
		return repository.findAll();
	}

}
