package com.rd.controller;

import java.util.List;

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

import com.rd.entity.Actor;
import com.rd.exception.ActorNotFoundException;
import com.rd.service.ActorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/actor")
@Slf4j
public class ActorController {
	
	
	@Autowired
	private ActorService actorService;

	@PostMapping("/register")
	public ResponseEntity<String> registeredActor(@RequestBody Actor actor){
		log.info("Actor Registering method Execution is start");
		String body = actorService.registerActor(actor);
		return new ResponseEntity<String>(body, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllActor(){
		log.info("Actor Get All Actor method Execution is start");
		List<Actor> body = actorService.getAllActor();
		return new ResponseEntity<List<Actor>>(body, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getActorId(@PathVariable Integer id)throws ActorNotFoundException{
		log.info("Actor Get All Actor method Execution is start");
		Actor body = actorService.getActorId(id);
		return new ResponseEntity<Actor>(body, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateActorInfo(@RequestBody Actor actor)throws ActorNotFoundException{
		log.info("Actor Updating method Execution is start");
		String body = actorService.updateActor(actor);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	@GetMapping("/findname/{name}")
	public ResponseEntity<List<Actor>> getActorByName(@PathVariable String name){
		List<Actor> body = actorService.getActorByName(name);
		return new ResponseEntity<List<Actor>>(body, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable Integer id)throws ActorNotFoundException{
		log.info("Actor Deleting method Execution is start ");
		String body = actorService.deleteActor(id);
          log.info("Actor Deleting method Execution is End ");
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	@PatchMapping("/partial/{id}/{category}")
	public ResponseEntity<String> partialUpdateActorInfo(@PathVariable Integer id, @PathVariable String category)throws ActorNotFoundException{
		log.info("Actor Partial Updating method Execution is start");
		String body = actorService.partialUpdateActor(id, category);
           log.info("Actor Partial Updating method Execution is End");
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}
