package com.nt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.Models.Actor;
import com.nt.Service.ServiceImpl;

@SpringBootApplication
public class BootLabD13Proj1LayeredActorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BootLabD13Proj1LayeredActorApplication.class, args);
		ServiceImpl bean = run.getBean("service",ServiceImpl.class);
		List<String> list=new ArrayList<>();
		list.add("aaaaa");
		list.add("bbbbb");
		list.add("ccccc");
		Actor act=new Actor(24,"sweety",list);
		
//		   System.out.println(bean.addActor(act));
//		     System.out.println("actor saved");
//		     System.out.println(bean.getAllActors());
//		     System.out.println(bean.getActorById(24));
		List<String> list1=new ArrayList<>();
		list1.add("zzzzz");
		list1.add("yyyyy");
		list1.add("xxxxx");
		     Actor actor=new Actor(25,"swikruti",list1);
		     
		     System.out.println(bean.updateActor(actor,10));
		    // System.out.println(bean.deleteActor(24));
		  //   System.out.println(bean.getActor("swikruti"));
	}

}
