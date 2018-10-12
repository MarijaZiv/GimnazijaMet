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
@Table(name = "modeli_placanja_i_stipendije")
public class Modeli_placanja_i_stipendije {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "model_placanja_id")
	private int id;

	@NotNull
	@Column(name = "naziv_modela")
	private String nazivModela;

	@NotNull
	@Column(name = "opis")
	private String opis;

	@Column(name = "popust")
	private Double popust;

	@Column(name = "kamata")
	private Double kamata;

	@Column(name = "zatezna_kamata")
	private Double zateznaKamata;

	// bi-directional many-to-one association to Cenovnik
	@OneToMany(mappedBy = "modeli_placanja_i_stipendije", cascade = CascadeType.ALL)
	private List<Cenovnik> cenovniks;

	public Modeli_placanja_i_stipendije() {

	}

	public Modeli_placanja_i_stipendije(int id, @NotNull String nazivModela, @NotNull String opis, Double popust,
			Double kamata, Double zateznaKamata, List<Cenovnik> cenovniks) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.opis = opis;
		this.popust = popust;
		this.kamata = kamata;
		this.zateznaKamata = zateznaKamata;
		this.cenovniks = cenovniks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivModela() {
		return nazivModela;
	}

	public void setNazivModela(String nazivModela) {
		this.nazivModela = nazivModela;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}

	public Double getKamata() {
		return kamata;
	}

	public void setKamata(Double kamata) {
		this.kamata = kamata;
	}

	public Double getZateznaKamata() {
		return zateznaKamata;
	}

	public void setZateznaKamata(Double zateznaKamata) {
		this.zateznaKamata = zateznaKamata;
	}

	public List<Cenovnik> getCenovniks() {
		return cenovniks;
	}

	public void setCenovniks(List<Cenovnik> cenovniks) {
		this.cenovniks = cenovniks;
	}

	@Override
	public String toString() {
		return "Modeli_placanja_i_stipendije [id=" + id + ", nazivModela=" + nazivModela + ", opis=" + opis
				+ ", popust=" + popust + ", kamata=" + kamata + ", zateznaKamata=" + zateznaKamata + ", cenovniks="
				+ cenovniks + "]";
	}

}
