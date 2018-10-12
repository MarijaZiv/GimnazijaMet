package com.gimnazijam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnazijam.entities.Roditelj;
import com.gimnazijam.repositories.RoditeljRepository;

@Service
public class RoditeljServiceImpl implements RoditeljService {

	@Autowired
	RoditeljRepository roditeljRepository;

	@Override
	public List<Roditelj> getAllRoditelj() {
		return (List<Roditelj>) roditeljRepository.findAll();
	}

	@Override
	public Roditelj getRoditeljById(int id) {
		return roditeljRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Roditelj roditelj) {
		roditeljRepository.save(roditelj);

	}

	@Override
	public void deleteRoditelj(int id) {
		roditeljRepository.deleteById(id);

	}

}
