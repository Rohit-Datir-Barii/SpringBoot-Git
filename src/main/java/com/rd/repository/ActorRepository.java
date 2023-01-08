package com.rd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rd.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
	@Query("FROM Actor WHERE aName=:actorName")
	public List<Actor> getActorByName(String actorName);

}
