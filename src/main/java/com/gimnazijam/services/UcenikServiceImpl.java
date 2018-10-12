package com.gimnazijam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnazijam.entities.Ucenik;
import com.gimnazijam.repositories.UcenikRepository;

@Service
public class UcenikServiceImpl implements UcenikService {

	@Autowired
	UcenikRepository ucenikRepository;

	@Override
	public List<Ucenik> getAllUcenik() {
		return (List<Ucenik>) ucenikRepository.findAll();
	}

	@Override
	public Ucenik getUcenikById(int id) {
		return ucenikRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Ucenik ucenik) {
		ucenikRepository.save(ucenik);

	}

	@Override
	public void deleteUcenik(int id) {
		ucenikRepository.deleteById(id);

	}

}
