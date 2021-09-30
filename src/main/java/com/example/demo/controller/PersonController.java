package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService service;

	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}

	// CREATE

	@PostMapping("/create")
	public ResponseEntity<Person> create(@RequestBody Person p) {
		return new ResponseEntity<Person>(this.service.create(p), HttpStatus.CREATED);
	}

	// READ ALL

	@GetMapping("/getAll")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity<List<Person>>(this.service.readAll(), HttpStatus.OK);
	}

	// READ ONE

	@GetMapping("/get/{id}")
	public ResponseEntity<Person> get(@PathVariable Long id) {
		return new ResponseEntity<Person>(this.service.read(id), HttpStatus.OK);

	}

	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person p) {
		return new ResponseEntity<Person>(this.service.update(p, id), HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

	// FIND BY NAME
	@GetMapping("/readname/{name}")
	public ResponseEntity<List<Person>> findByName(@PathVariable String name) {
		return new ResponseEntity<List<Person>>(this.service.findByName(name), HttpStatus.OK);
	}

}
