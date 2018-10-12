package com.gimnazijam.entities;

import java.security.Timestamp;

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
@Table(name = "roditeljski_sastanak")
public class Roditeljski_sastanak {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roditeljski_sastanak_id")
	private int id;

	@NotNull
	@Column(name = "datum")
	private Timestamp datum;

	@Column(name = "napomena")
	private String napomena;

	// bi-directional many-to-one association to Roditelj
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "roditelj_id", nullable = false)
	private Roditelj roditelj;

	// bi-directional many-to-one association to Zaposleni
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "zaposleni_id", nullable = false)
	private Zaposleni zaposleni;

	public Roditeljski_sastanak() {

	}

	public Roditeljski_sastanak(int id, @NotNull Timestamp datum, String napomena, Roditelj roditelj,
			Zaposleni zaposleni) {
		super();
		this.id = id;
		this.datum = datum;
		this.napomena = napomena;
		this.roditelj = roditelj;
		this.zaposleni = zaposleni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatum() {
		return datum;
	}

	public void setDatum(Timestamp datum) {
		this.datum = datum;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Roditelj getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Roditelj roditelj) {
		this.roditelj = roditelj;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

}
