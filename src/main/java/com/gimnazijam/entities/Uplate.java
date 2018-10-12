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
@Table(name = "uplate")
public class Uplate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uplate_id")
	private int id;

	@NotNull
	@Column(name = "datum_placanja")
	private Date datumPlacanja;

	@Column(name = "iznos_uplate_din")
	private Double iznosUplateDin;

	@Column(name = "iznos_uplate_eur")
	private Double iznosUplateEur;

	@Column(name = "srednji_kurs")
	private Double srednjiKurs;

	@Column(name = "napomena")
	private String napomena;

	// bi-directional many-to-one association to Zaduzenja
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "zaduzenja_id", nullable = false)
	private Zaduzenja zaduzenja;

	public Uplate() {

	}

	public Uplate(int id, @NotNull Date datumPlacanja, Double iznosUplateDin, Double iznosUplateEur, Double srednjiKurs,
			String napomena, Zaduzenja zaduzenja) {
		super();
		this.id = id;
		this.datumPlacanja = datumPlacanja;
		this.iznosUplateDin = iznosUplateDin;
		this.iznosUplateEur = iznosUplateEur;
		this.srednjiKurs = srednjiKurs;
		this.napomena = napomena;
		this.zaduzenja = zaduzenja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumPlacanja() {
		return datumPlacanja;
	}

	public void setDatumPlacanja(Date datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	public Double getIznosUplateDin() {
		return iznosUplateDin;
	}

	public void setIznosUplateDin(Double iznosUplateDin) {
		this.iznosUplateDin = iznosUplateDin;
	}

	public Double getIznosUplateEur() {
		return iznosUplateEur;
	}

	public void setIznosUplateEur(Double iznosUplateEur) {
		this.iznosUplateEur = iznosUplateEur;
	}

	public Double getSrednjiKurs() {
		return srednjiKurs;
	}

	public void setSrednjiKurs(Double srednjiKurs) {
		this.srednjiKurs = srednjiKurs;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public Zaduzenja getZaduzenja() {
		return zaduzenja;
	}

	public void setZaduzenja(Zaduzenja zaduzenja) {
		this.zaduzenja = zaduzenja;
	}

}
