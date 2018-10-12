package com.gimnazijam.services;

import java.util.List;

import com.gimnazijam.entities.Roditelj;

public interface RoditeljService {

	public List<Roditelj> getAllRoditelj();

	public Roditelj getRoditeljById(int Id);

	public void saveOrUpdate(Roditelj roditelj);

	public void deleteRoditelj(int Id);

}
