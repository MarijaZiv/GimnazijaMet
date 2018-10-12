package com.gimnazijam.entities;

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
@Table(name = "prisustvo")
public class Prisustvo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prisustvo_id")
	private int id;

	@NotNull
	@Column(name = "opravdano_odsustvo")
	private int opravdano;

	// bi-directional many-to-one association to Cas
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cas_id", nullable = false)
	private Cas cas;

	// bi-directional many-to-one association to Ucenik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ucenik_id", nullable = false)
	private Ucenik ucenik;

	public Prisustvo() {

	}

	public Prisustvo(int id, @NotNull int opravdano, Cas cas, Ucenik ucenik) {
		super();
		this.id = id;
		this.opravdano = opravdano;
		this.cas = cas;
		this.ucenik = ucenik;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOpravdano() {
		return opravdano;
	}

	public void setOpravdano(int opravdano) {
		this.opravdano = opravdano;
	}

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

}
