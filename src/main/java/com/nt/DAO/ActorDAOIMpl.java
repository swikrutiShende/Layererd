package com.nt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.stereotype.Repository;

import com.nt.Models.Actor;


@DependsOnDatabaseInitialization
@Repository("dao")
public class ActorDAOIMpl implements IActorDAO {
	@Autowired
	DataSource ds;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Actor> getAllActors() {
		List<Actor> list = new ArrayList<>();

		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from actor");) {

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Actor act = new Actor();
                        act.setId(rs.getInt(1));
                        act.setName(rs.getString(2));
                        String str=rs.getString(3);
                        String[] split = str.split(",");
                        List<String> asList = Arrays.asList(split);
                        act.setMovies(asList);
                        
					

					System.out.println("fetched");
					list.add(act);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return list;

	}

	@Override
	public Actor getActorById(int id) {
		Actor d=null;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from Actor where id=?");) {
			ps.setInt(1, id);
			System.out.println("StudentImplDAO.FindByid()");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					 d = new Actor();
            System.out.println("FindByid()");
            d.setId(rs.getInt(1));
			d.setName(rs.getString(2));
			String str=rs.getString(3);
            String[] split = str.split(",");
            List<String> asList = Arrays.asList(split);
            d.setMovies(asList);
            
					System.out.println("fetched");
					}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return d;
	}

	@Override
	public String addActor(Actor actor) {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into Actor values(?,?,?)");) {
			ps.setInt(1, actor.getId());
			ps.setString(2, actor.getName());
			List<String> movies = actor.getMovies();
			String string = movies.toString();
			ps.setString(3, string);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data saved";
	}

	@Override
	public String updateActor(Actor actor,int id) {
		Actor d=null;
		int k=0;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("update actor set name=? , movies=? where id=? ");) {
			ps.setString(1, actor.getName());
			
			List<String> movies = actor.getMovies();
			String string = movies.toString();
			ps.setString(2, string);
			ps.setInt(3, id);
			k=ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(k>0)return "updated";
		else return "not updated";
	}

	@Override
	public String deleteActor(int id) {
	int k=0;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from actor where id=? ");) {
			ps.setInt(1,id);
			k=ps.executeUpdate();
			System.out.println("ActorDAOIMpl.deleteActor()");

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(k>0)return "delete";
		else return "not deleted";
	}

	@Override
	public Actor getActor(String actorName) {
		Actor act=null;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from Actor where name=?");) {
			ps.setString(1,actorName);
			System.out.println("StudentImplDAO.FindByid()");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					 act= new Actor();
            System.out.println("FindByid()");
            act.setId(rs.getInt(1));
			act.setName(rs.getString(2));
			String str=rs.getString(3);
            String[] split = str.split(",");
            List<String> asList = Arrays.asList(split);
            act.setMovies(asList);
            
					System.out.println("fetched");
					}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return act;
	}

}
