package com.gimnazijam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnazijam.entities.Ucenik;

@Repository
public interface UcenikRepository extends JpaRepository<Ucenik, Integer> {

}
