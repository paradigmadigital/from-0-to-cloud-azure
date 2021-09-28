package com.paradigmadigital.watto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired private UserRepository repository;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user){
		Assert.notNull(user.getUsername(), "Empty username");
		Assert.notNull(user.getPassword(), "Empty password");
		
		User usr = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (usr != null) {
			return ResponseEntity.ok(usr);	
		}
		return ResponseEntity.noContent().build();
	}

}
