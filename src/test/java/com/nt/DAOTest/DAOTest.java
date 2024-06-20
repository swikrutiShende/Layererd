package com.nt.DAOTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nt.DAO.IActorDAO;
import com.nt.Models.Actor;

@SpringBootTest
public class DAOTest {
	@Autowired
	IActorDAO dao;
	List<String> list = null;
	Actor act = null;

	@BeforeEach
	public void object() {
		System.out.println("DAOTest.object()");
		list = new ArrayList<>();
		list.add("aaaa");
		list.add("bbbb");
		act = new Actor(24, "sweety", list);
		
	}

	@Test
	public void getActTest() {
		List<Actor> allActors = dao.getAllActors();
		Assertions.assertEquals(true, allActors.size() > 1);
	}

	@Test
	public void addActTest() {
		String actor = dao.addActor(act);
		Assertions.assertEquals("data saved", actor);
	}

	@Test
	public void updateActTest() {
		String actor = dao.updateActor(act, 24);
		Assertions.assertEquals("updated", actor);
	}
	@Test
	public void DeleteActTest() {
		String actor = dao.deleteActor(24);
		Assertions.assertEquals("delete", actor);
	}
}
