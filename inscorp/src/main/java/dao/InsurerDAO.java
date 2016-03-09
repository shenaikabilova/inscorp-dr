package dao;

import java.util.List;

import model.Insurer;

public interface InsurerDAO {
	public List<Insurer> listInsurers();
	public void insert(Insurer insurer);
	public void delete(String insurerID);
	public void update(Insurer insurer);
	public Insurer searchUserName (String username);
}