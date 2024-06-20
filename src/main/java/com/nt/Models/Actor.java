package com.nt.Models;

import java.util.List;

import lombok.Data;
@Data

public class Actor {
private int id;
private String name;
private List<String> movies;
public Actor(int id, String name, List<String> movies) {
	super();
	this.id = id;
	this.name = name;
	this.movies = movies;
}
public Actor() {
	// TODO Auto-generated constructor stub
}

}
