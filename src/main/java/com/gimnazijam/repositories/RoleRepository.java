package com.gimnazijam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnazijam.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByNazivRole(String nazivRole);

}
