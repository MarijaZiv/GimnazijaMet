package com.gimnazijam.services;

import java.util.List;

import com.gimnazijam.entities.Zaposleni;

public interface ZaposleniService {

	public List<Zaposleni> getAllZaposleni();

	public Zaposleni getZaposleniById(int Id);

	public void saveOrUpdate(Zaposleni zaposleni);

	public void deleteZaposleni(int Id);

}
