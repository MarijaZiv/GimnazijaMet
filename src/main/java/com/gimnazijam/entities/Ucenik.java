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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ucenik")
public class Ucenik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ucenik_id")
	private int id;

	@NotNull
	@Column(name = "broj_knjizice")
	private String brojKnjizice;

	@NotNull
	@Column(name = "ime_roditelja")
	private String imeRoditelja;

	@NotNull
	@Column(name = "osnovna_skola")
	private String osnovnaSkola;

	// bi-directional many-to-many association to Roditelj
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ucenik_roditelj", joinColumns = @JoinColumn(name = "ucenik_id"), inverseJoinColumns = @JoinColumn(name = "roditelj_id"))
	private List<Roditelj> roditeljs;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// bi-directional many-to-one association to Upis
	@OneToMany(mappedBy = "ucenik", cascade = CascadeType.ALL)
	private List<Upis> upiss;

	// bi-directional many-to-one association to Ucenik_predmet
	@OneToMany(mappedBy = "ucenik", cascade = CascadeType.ALL)
	private List<Ucenik_predmet> ucenik_predmets;

	// bi-directional many-to-one association to Prisustvo
	@OneToMany(mappedBy = "ucenik", cascade = CascadeType.ALL)
	private List<Prisustvo> prisustvos;

	public Ucenik() {

	}

	public Ucenik(int id, @NotNull String brojKnjizice, @NotNull String imeRoditelja, @NotNull String osnovnaSkola,
			List<Roditelj> roditeljs, User user, List<Upis> upiss, List<Ucenik_predmet> ucenik_predmets,
			List<Prisustvo> prisustvos) {
		super();
		this.id = id;
		this.brojKnjizice = brojKnjizice;
		this.imeRoditelja = imeRoditelja;
		this.osnovnaSkola = osnovnaSkola;
		this.roditeljs = roditeljs;
		this.user = user;
		this.upiss = upiss;
		this.ucenik_predmets = ucenik_predmets;
		this.prisustvos = prisustvos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrojKnjizice() {
		return brojKnjizice;
	}

	public void setBrojKnjizice(String brojKnjizice) {
		this.brojKnjizice = brojKnjizice;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getOsnovnaSkola() {
		return osnovnaSkola;
	}

	public void setOsnovnaSkola(String osnovnaSkola) {
		this.osnovnaSkola = osnovnaSkola;
	}

	public List<Roditelj> getRoditeljs() {
		return roditeljs;
	}

	public void setRoditeljs(List<Roditelj> roditeljs) {
		this.roditeljs = roditeljs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Upis> getUpiss() {
		return upiss;
	}

	public void setUpiss(List<Upis> upiss) {
		this.upiss = upiss;
	}

	public List<Ucenik_predmet> getUcenik_predmets() {
		return ucenik_predmets;
	}

	public void setUcenik_predmets(List<Ucenik_predmet> ucenik_predmets) {
		this.ucenik_predmets = ucenik_predmets;
	}

	public List<Prisustvo> getPrisustvos() {
		return prisustvos;
	}

	public void setPrisustvos(List<Prisustvo> prisustvos) {
		this.prisustvos = prisustvos;
	}

	@Override
	public String toString() {
		return "Ucenik [id=" + id + ", brojKnjizice=" + brojKnjizice + ", imeRoditelja=" + imeRoditelja
				+ ", osnovnaSkola=" + osnovnaSkola + ", roditeljs=" + roditeljs + ", user=" + user + ", upiss=" + upiss
				+ ", ucenik_predmets=" + ucenik_predmets + ", prisustvos=" + prisustvos + "]";
	}

}
