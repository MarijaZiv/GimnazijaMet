package com.gimnazijam.services;

import java.util.List;

import com.gimnazijam.entities.Ucenik;

public interface UcenikService {

	public List<Ucenik> getAllUcenik();

	public Ucenik getUcenikById(int id);

	public void saveOrUpdate(Ucenik ucenik);

	public void deleteUcenik(int id);

}
