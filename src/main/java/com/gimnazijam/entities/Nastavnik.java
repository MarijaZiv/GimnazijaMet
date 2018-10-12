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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nastavnik")
public class Nastavnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nastavnik_id")
	private int id;

	@NotNull
	@Column(name = "fakultet")
	private String fakultet;

	@NotNull
	@Column(name = "razredni")
	private int razredni;

	// bi-directional many-to-one association to Zaposleni
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "zaposleni_id", nullable = false)
	private Zaposleni zaposleni;

	// bi-directional many-to-one association to Angazovanje
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.ALL)
	private List<Angazovanje> angazovanjes;

	// bi-directional many-to-one association to Cas
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.ALL)
	private List<Cas> cass;

	// bi-directional many-to-one association to Ucenik_predmet
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.ALL)
	private List<Ucenik_predmet> ucenik_predmets;

	// bi-directional many-to-one association to Odeljenje
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.ALL)
	private List<Odeljenje> odeljenjes;

	public Nastavnik() {

	}

	public Nastavnik(int id, @NotNull String fakultet, @NotNull int razredni, Zaposleni zaposleni,
			List<Angazovanje> angazovanjes, List<Cas> cass, List<Ucenik_predmet> ucenik_predmets,
			List<Odeljenje> odeljenjes) {
		super();
		this.id = id;
		this.fakultet = fakultet;
		this.razredni = razredni;
		this.zaposleni = zaposleni;
		this.angazovanjes = angazovanjes;
		this.cass = cass;
		this.ucenik_predmets = ucenik_predmets;
		this.odeljenjes = odeljenjes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFakultet() {
		return fakultet;
	}

	public void setFakultet(String fakultet) {
		this.fakultet = fakultet;
	}

	public int getRazredni() {
		return razredni;
	}

	public void setRazredni(int razredni) {
		this.razredni = razredni;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public List<Angazovanje> getAngazovanjes() {
		return angazovanjes;
	}

	public void setAngazovanjes(List<Angazovanje> angazovanjes) {
		this.angazovanjes = angazovanjes;
	}

	public List<Cas> getCass() {
		return cass;
	}

	public void setCass(List<Cas> cass) {
		this.cass = cass;
	}

	public List<Ucenik_predmet> getUcenik_predmets() {
		return ucenik_predmets;
	}

	public void setUcenik_predmets(List<Ucenik_predmet> ucenik_predmets) {
		this.ucenik_predmets = ucenik_predmets;
	}

	public List<Odeljenje> getOdeljenjes() {
		return odeljenjes;
	}

	public void setOdeljenjes(List<Odeljenje> odeljenjes) {
		this.odeljenjes = odeljenjes;
	}

	@Override
	public String toString() {
		return "Nastavnik [id=" + id + ", fakultet=" + fakultet + ", razredni=" + razredni + ", zaposleni=" + zaposleni
				+ ", angazovanjes=" + angazovanjes + ", cass=" + cass + ", ucenik_predmets=" + ucenik_predmets
				+ ", odeljenjes=" + odeljenjes + "]";
	}

}
