package com.gimnazijam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;

	@NotNull
	@Column(name = "naziv_role")
	private String nazivRole;

	public Role() {

	}

	public Role(int id, @NotNull String nazivRole) {
		super();
		this.id = id;
		this.nazivRole = nazivRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivRole() {
		return nazivRole;
	}

	public void setNazivRole(String nazivRole) {
		this.nazivRole = nazivRole;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nazivRole=" + nazivRole + "]";
	}

}
