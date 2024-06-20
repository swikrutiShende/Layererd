package com.nt.Service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.DAO.IActorDAO;
import com.nt.Models.Actor;

public class ActorServiceTest {
	List<String> list = null;
	Actor act = null;

	@BeforeEach
	public void setUp() {
		
		list = new ArrayList<>();
		list.add("aaaa");
		list.add("bbbb");
		act = new Actor(24, "sweety", list);
		
	}

	@Test
	public void addActTest() {
		ServiceImpl serviceImpl = new ServiceImpl();
		IActorDAO mock = Mockito.mock(IActorDAO.class);
		serviceImpl.setDao(mock);
		when(mock.addActor(act)).thenReturn("data saved");
		Assertions.assertEquals("data saved", serviceImpl.addActor(act));

	}

	@Test
	public void updateActTest() {
		ServiceImpl serviceImpl = new ServiceImpl();
		IActorDAO mock = Mockito.mock(IActorDAO.class);
		serviceImpl.setDao(mock);
		when(mock.updateActor(act, 2)).thenReturn("updated");
		Assertions.assertEquals("updated", serviceImpl.updateActor(act, 2));

	}
	
	@Test
	public void DeleteActTest() {
		ServiceImpl serviceImpl = new ServiceImpl();
		IActorDAO mock = Mockito.mock(IActorDAO.class);
		serviceImpl.setDao(mock);
		when(mock.deleteActor(2)).thenReturn("delete");
		Assertions.assertEquals("delete", serviceImpl.deleteActor(2));

	}

}
