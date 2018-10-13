package com.gimnazijam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnazijam.entities.Roditelj;

@Repository
public interface RoditeljRepository extends JpaRepository<Roditelj, Integer> {

	void save(int roditelj_id);

}
