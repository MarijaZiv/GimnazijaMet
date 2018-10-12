package com.gimnazijam.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roditelj")
public class Roditelj {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roditelj_id")
	private int id;

	// bi-directional many-to-many association to Ucenik
	@ManyToMany(mappedBy = "roditeljs")
	private List<Ucenik> uceniks;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// bi-directional many-to-one association to Roditeljski_sastanak
	@OneToMany(mappedBy = "roditelj", cascade = CascadeType.ALL)
	private List<Roditeljski_sastanak> roditeljski_sastanaks;

	public Roditelj() {

	}

	public Roditelj(int id, List<Ucenik> uceniks, User user, List<Roditeljski_sastanak> roditeljski_sastanaks) {
		super();
		this.id = id;
		this.uceniks = uceniks;
		this.user = user;
		this.roditeljski_sastanaks = roditeljski_sastanaks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ucenik> getUceniks() {
		return uceniks;
	}

	public void setUceniks(List<Ucenik> uceniks) {
		this.uceniks = uceniks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Roditeljski_sastanak> getRoditeljski_sastanaks() {
		return roditeljski_sastanaks;
	}

	public void setRoditeljski_sastanaks(List<Roditeljski_sastanak> roditeljski_sastanaks) {
		this.roditeljski_sastanaks = roditeljski_sastanaks;
	}

	@Override
	public String toString() {
		return "Roditelj [id=" + id + ", uceniks=" + uceniks + ", user=" + user + ", roditeljski_sastanaks="
				+ roditeljski_sastanaks + "]";
	}

}
