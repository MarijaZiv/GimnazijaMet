package com.gimnazijam.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ucenik_predmet")
public class Ucenik_predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ucenik_predmet_id")
	private int id;

	@NotNull
	@Column(name = "ocena")
	private int ocena;

	@NotNull
	@Column(name = "tip_ocene")
	private String tipOcene;

	@NotNull
	@Column(name = "polugodiste")
	private int polugodiste;

	@NotNull
	@Column(name = "datum_unosa")
	private Date datumUnosa;

	@Column(name = "napomena")
	private String napomena;

	// bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavnik_id", nullable = false)
	private Nastavnik nastavnik;

	// bi-directional many-to-one association to Ucenik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ucenik_id", nullable = false)
	private Ucenik ucenik;

	// bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavni_plan_predmet_id", nullable = false)
	private Nastavni_plan_predmet nastavni_plan_predmet;

	public Ucenik_predmet() {

	}

	public Ucenik_predmet(int id, @NotNull int ocena, @NotNull String tipOcene, @NotNull int polugodiste,
			@NotNull Date datumUnosa, String napomena, Nastavnik nastavnik, Ucenik ucenik,
			Nastavni_plan_predmet nastavni_plan_predmet) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.tipOcene = tipOcene;
		this.polugodiste = polugodiste;
		this.datumUnosa = datumUnosa;
		this.napomena = napomena;
		this.nastavnik = nastavnik;
		this.ucenik = ucenik;
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getTipOcene() {
		return tipOcene;
	}

	public void setTipOcene(String tipOcene) {
		this.tipOcene = tipOcene;
	}

	public int getPolugodiste() {
		return polugodiste;
	}

	public void setPolugodiste(int polugodiste) {
		this.polugodiste = polugodiste;
	}

	public Date getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Nastavni_plan_predmet getNastavni_plan_predmet() {
		return nastavni_plan_predmet;
	}

	public void setNastavni_plan_predmet(Nastavni_plan_predmet nastavni_plan_predmet) {
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

}
