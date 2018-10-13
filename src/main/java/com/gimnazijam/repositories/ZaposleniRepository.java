package com.gimnazijam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnazijam.entities.Zaposleni;

@Repository
public interface ZaposleniRepository extends JpaRepository<Zaposleni, Integer> {

	List<Zaposleni> findById(int zaposleni_id);

	void save(int zaposleni_id);

}
