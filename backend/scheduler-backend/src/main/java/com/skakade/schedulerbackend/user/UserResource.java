package com.skakade.schedulerbackend.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserResource {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/users")
	public ResponseEntity<User> addNewUser(
			@RequestBody User user ){



		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
			path("/{id}").buildAndExpand( new User().getId() ).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(path="/users")
	public List<User> getAllUserNames(){
		return userRepository.findAll();

	}
}
