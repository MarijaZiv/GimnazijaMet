package com.gimnazijam.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "predmet")
public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "predmet_id")
	private int id;

	@NotNull
	@Column(name = "sifra")
	private String sifra;

	@NotNull
	@Column(name = "pun_naziv")
	private String punNaziv;

	// bi-directional many-to-one association to Nastavni_plan_predmet
	@OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL)
	private List<Nastavni_plan_predmet> nastavni_plan_predmets;

	public Predmet() {

	}

	public Predmet(int id, @NotNull String sifra, @NotNull String punNaziv,
			List<Nastavni_plan_predmet> nastavni_plan_predmets) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.punNaziv = punNaziv;
		this.nastavni_plan_predmets = nastavni_plan_predmets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getPunNaziv() {
		return punNaziv;
	}

	public void setPunNaziv(String punNaziv) {
		this.punNaziv = punNaziv;
	}

	public List<Nastavni_plan_predmet> getNastavni_plan_predmets() {
		return nastavni_plan_predmets;
	}

	public void setNastavni_plan_predmets(List<Nastavni_plan_predmet> nastavni_plan_predmets) {
		this.nastavni_plan_predmets = nastavni_plan_predmets;
	}

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", sifra=" + sifra + ", punNaziv=" + punNaziv + "]";
	}

}
