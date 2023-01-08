package com.rd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.entity.Actor;
import com.rd.exception.ActorNotFoundException;
import com.rd.repository.ActorRepository;
@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;

	@Override
	public String registerActor(Actor actor) {
		// use the repository
		Integer id = actorRepository.save(actor).getAId();
		return "Actor is saved successfully with Id : "+id;
	}

	@Override
	public List<Actor> getAllActor() {
		// use the repository
		List<Actor> findAllActor = actorRepository.findAll();
		return findAllActor;
	}

	@Override
	public Actor getActorId(Integer id)throws ActorNotFoundException{
		// use the repository
		return actorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Actor is not found to display"));
	}

	@Override
	public String updateActor(Actor actor)throws ActorNotFoundException{
		// use the actor
		Optional<Actor> aId = actorRepository.findById(actor.getAId());
		if(aId.isPresent()) {
			actorRepository.save(actor);
			return "Actor Updated Successfully with Id : "+actor.getAId();
		}
		throw new ActorNotFoundException("Actor is not Updated please try again ");
	}

	@Override
	public String deleteActor(Integer id)throws ActorNotFoundException{
		//use the service
		Optional<Actor> aId = actorRepository.findById(id);
		if(aId.isPresent()) {
			actorRepository.delete(aId.get());
			return "Actor Deleted Successfully with Id : "+id;
		}else {
			throw new ActorNotFoundException("Actor is not Deleted please try again ");
		}
	}

	@Override
	public String partialUpdateActor(Integer id, String category) throws ActorNotFoundException{
		// use the service
		Optional<Actor> aId = actorRepository.findById(id);
		if(aId.isPresent()) {
			Actor actor=aId.get();
			actor.setACategory(category);
			actorRepository.save(actor);
			return "Actor Partially Updated";
		}else {
			throw new ActorNotFoundException("Actor is not partial updated please try again ");
		}
	}
	
	@Override
	public List<Actor> getActorByName(String name) {
		// use the repository
		List<Actor> actorByName = actorRepository.getActorByName(name);
		return actorByName;
	}

}
