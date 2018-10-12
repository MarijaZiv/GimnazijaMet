package com.gimnazijam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnazijam.entities.Zaposleni;
import com.gimnazijam.repositories.ZaposleniRepository;

@Service
public class ZaposleniServiceImpl implements ZaposleniService {

	@Autowired
	ZaposleniRepository zaposleniRepository;

	@Override
	public List<Zaposleni> getAllZaposleni() {
		return (List<Zaposleni>) zaposleniRepository.findAll();
	}

	@Override
	public Zaposleni getZaposleniById(int id) {
		return zaposleniRepository.findById(id).get(id);
	}

	@Override
	public void saveOrUpdate(Zaposleni zaposleni) {
		zaposleniRepository.save(zaposleni);

	}

	@Override
	public void deleteZaposleni(int id) {
		zaposleniRepository.deleteById(id);

	}

}