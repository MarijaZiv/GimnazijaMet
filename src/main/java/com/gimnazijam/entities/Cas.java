package com.gimnazijam.entities;

import java.util.Date;
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
@Table(name = "cas")
public class Cas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cas_id")
	private int id;

	@NotNull
	@Column(name = "redni_broj_casa")
	private int redniBrojCasa;

	@NotNull
	@Column(name = "ukupan_broj_casova")
	private int ukupanBrojCasova;

	@NotNull
	@Column(name = "opis_casa")
	private String opisCasa;

	@Column(name = "napomena")
	private String napomena;

	@NotNull
	@Column(name = "datum_unosa")
	private Date datumUnosa;

	// bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavnik_id", nullable = false)
	private Nastavnik nastavnik;

	// bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavni_plan_predmet_id", nullable = false)
	private Nastavni_plan_predmet nastavni_plan_predmet;

	// bi-directional many-to-one association to Odeljenje
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "odeljenje_id", nullable = false)
	private Odeljenje odeljenje;

	// bi-directional many-to-one association to Prisustvo
	@OneToMany(mappedBy = "cas", cascade = CascadeType.ALL)
	private List<Prisustvo> prisustvos;

	public Cas() {

	}

	public Cas(int id, @NotNull int redniBrojCasa, @NotNull int ukupanBrojCasova, @NotNull String opisCasa,
			String napomena, @NotNull Date datumUnosa, Nastavnik nastavnik, Nastavni_plan_predmet nastavni_plan_predmet,
			Odeljenje odeljenje, List<Prisustvo> prisustvos) {
		super();
		this.id = id;
		this.redniBrojCasa = redniBrojCasa;
		this.ukupanBrojCasova = ukupanBrojCasova;
		this.opisCasa = opisCasa;
		this.napomena = napomena;
		this.datumUnosa = datumUnosa;
		this.nastavnik = nastavnik;
		this.nastavni_plan_predmet = nastavni_plan_predmet;
		this.odeljenje = odeljenje;
		this.prisustvos = prisustvos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRedniBrojCasa() {
		return redniBrojCasa;
	}

	public void setRedniBrojCasa(int redniBrojCasa) {
		this.redniBrojCasa = redniBrojCasa;
	}

	public int getUkupanBrojCasova() {
		return ukupanBrojCasova;
	}

	public void setUkupanBrojCasova(int ukupanBrojCasova) {
		this.ukupanBrojCasova = ukupanBrojCasova;
	}

	public String getOpisCasa() {
		return opisCasa;
	}

	public void setOpisCasa(String opisCasa) {
		this.opisCasa = opisCasa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Date getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Nastavni_plan_predmet getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(Nastavni_plan_predmet nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public List<Prisustvo> getPrisustvos() {
		return prisustvos;
	}

	public void setPrisustvos(List<Prisustvo> prisustvos) {
		this.prisustvos = prisustvos;
	}

	@Override
	public String toString() {
		return "Cas [id=" + id + ", redniBrojCasa=" + redniBrojCasa + ", ukupanBrojCasova=" + ukupanBrojCasova
				+ ", opisCasa=" + opisCasa + ", napomena=" + napomena + ", datumUnosa=" + datumUnosa + ", nastavnik="
				+ nastavnik + ", nastavni_plan_predmet=" + nastavni_plan_predmet + ", odeljenje=" + odeljenje
				+ ", prisustvos=" + prisustvos + "]";
	}

}
