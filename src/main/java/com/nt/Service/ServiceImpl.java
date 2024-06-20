package com.nt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.DAO.IActorDAO;
import com.nt.Models.Actor;

@Service("service")
public class ServiceImpl implements IServiceActor {
    @Autowired
    IActorDAO dao;
	public IActorDAO getDao() {
		return dao;
	}

	public void setDao(IActorDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Actor> getAllActors() {
		List<Actor> list=dao.getAllActors();
		return list;
	}

	@Override
	public Actor getActorById(int id) {
		Actor act=null;
		if(id>0) {
		act=dao.getActorById(id);
		}
		else throw  new IllegalArgumentException("id can't be >0");
		return act;
	}

	@Override
	public String addActor(Actor actor) {
		
		return dao.addActor(actor);
	}

	@Override
	public String updateActor(Actor actor,int id) {
		// TODO Auto-generated method stub
		return dao.updateActor(actor,id);
	}

	@Override
	public String deleteActor(int id) {
		// TODO Auto-generated method stub
		return dao.deleteActor(id);
	}

	@Override
	public Actor getActor(String actorName) {
		// TODO Auto-generated method stub
		return dao.getActor(actorName);
	}

}
