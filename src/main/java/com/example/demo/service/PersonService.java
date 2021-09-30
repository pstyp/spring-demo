package com.example.demo.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Person;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.repo.PersonRepo;

@Service
public class PersonService {
	
	
	private PersonRepo repo; 
	
	public PersonService(PersonRepo repo) {
		this.repo=repo;
	}
	
	//CREATE
	public Person create(Person p) {
		return this.repo.saveAndFlush(p);
	}
	
	// READ ALL
	public List<Person> readAll() {
		return this.repo.findAll();
	}
	
	// READ ID
	public Person read(Long id) {
		return this.repo.findById(id).get();
	}
	
	// UPDATE
	public Person update(Person p, Long id) {
		Person exPer = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
		exPer.setFirstName(p.getFirstName());
		exPer.setLastName(p.getLastName());
		return this.repo.saveAndFlush(exPer);
	}
	// DELETE
	public Boolean delete(Long id) {
		if(!this.repo.existsById(id)) {
			throw new PersonNotFoundException();
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
	// FIND BY NAME
	public List<Person> findByName(String name) {
		return this.repo.findByName(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	private List<Person> people = new ArrayList<>();
//
//	public Person addPerson(Person person) {
//		// Add new Person
//		this.people.add(person);
//		// Return last added Person from List
//		return this.people.get(this.people.size() - 1);
//	}
//
//	public List<Person> getAllPeople() {
//		// Return the whole List
//		return this.people;
//	}
//
//	public Person updatePerson(int id, Person person) {
//		// Remove existing Person with matching 'id'
//		this.people.remove(id);
//		// Add new Person in its place
//		this.people.add(id, person);
//		// Return updated Person from List
//		return this.people.get(id);
//	}
//
//	public Person removePerson(int id) {
//		// Remove Person and return it
//		return this.people.remove(id);
//	}

}
