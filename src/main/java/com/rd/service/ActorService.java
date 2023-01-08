package com.rd.service;

import java.util.List;

import com.rd.entity.Actor;
import com.rd.exception.ActorNotFoundException;

public interface ActorService {
	
	public String registerActor(Actor actor);
	public List<Actor> getAllActor();
	public Actor getActorId(Integer id)throws ActorNotFoundException;
	public String updateActor(Actor actor)throws ActorNotFoundException;
	public String deleteActor(Integer id)throws ActorNotFoundException;
	public String partialUpdateActor(Integer id,String category)throws ActorNotFoundException;
    public List<Actor> getActorByName(String name);
}
