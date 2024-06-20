package com.nt.DAO;

import java.util.List;

import com.nt.Models.Actor;

public interface IActorDAO {
	List<Actor> getAllActors();

	Actor getActorById(int id);

	String addActor(Actor actor);

	String updateActor(Actor actor,int id);

	String deleteActor(int id);

	Actor getActor(String actorName);
}
