package com.gimnazijam.entities;

import java.sql.Timestamp;
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
@Table(name = "cenovnik")
public class Cenovnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cenovnik_id")
	private int id;

	@NotNull
	@Column(name = "naziv_stavke")
	private String nazivStavke;

	@NotNull
	@Column(name = "sifra_stavke")
	private int sifraStavke;

	@NotNull
	@Column(name = "cena_stavke")
	private int cenaStavke;

	@NotNull
	@Column(name = "valuta")
	private String valuta;

	@NotNull
	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "date_modified")
	private Timestamp dateModified;

	@Column(name = "modified_by")
	private int modifiedBy;

	// bi-directional many-to-one association to Modeli_placanja_i_stipendije
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "modeli_placanja_i_stipendije_id", nullable = false)
	private Modeli_placanja_i_stipendije modeli_placanja_i_stipendije;

	// bi-directional many-to-one association to Skolska_godina
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "skolska_godina_id", nullable = false)
	private Skolska_godina skolska_godina;

	// bi-directional many-to-one association to Zaduzenja
	@OneToMany(mappedBy = "cenovnik", cascade = CascadeType.ALL)
	private List<Zaduzenja> Zaduzenjas;

	public Cenovnik() {

	}

	public Cenovnik(int id, @NotNull String nazivStavke, @NotNull int sifraStavke, @NotNull int cenaStavke,
			@NotNull String valuta, @NotNull Timestamp dateCreated, int createdBy, Timestamp dateModified,
			int modifiedBy, Modeli_placanja_i_stipendije modeli_placanja_i_stipendije, Skolska_godina skolska_godina,
			List<Zaduzenja> zaduzenjas) {
		super();
		this.id = id;
		this.nazivStavke = nazivStavke;
		this.sifraStavke = sifraStavke;
		this.cenaStavke = cenaStavke;
		this.valuta = valuta;
		this.dateCreated = dateCreated;
		this.createdBy = createdBy;
		this.dateModified = dateModified;
		this.modifiedBy = modifiedBy;
		this.modeli_placanja_i_stipendije = modeli_placanja_i_stipendije;
		this.skolska_godina = skolska_godina;
		Zaduzenjas = zaduzenjas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivStavke() {
		return nazivStavke;
	}

	public void setNazivStavke(String nazivStavke) {
		this.nazivStavke = nazivStavke;
	}

	public int getSifraStavke() {
		return sifraStavke;
	}

	public void setSifraStavke(int sifraStavke) {
		this.sifraStavke = sifraStavke;
	}

	public int getCenaStavke() {
		return cenaStavke;
	}

	public void setCenaStavke(int cenaStavke) {
		this.cenaStavke = cenaStavke;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Modeli_placanja_i_stipendije getModeli_placanja_i_stipendije() {
		return modeli_placanja_i_stipendije;
	}

	public void setModeli_placanja_i_stipendije(Modeli_placanja_i_stipendije modeli_placanja_i_stipendije) {
		this.modeli_placanja_i_stipendije = modeli_placanja_i_stipendije;
	}

	public Skolska_godina getSkolska_godina() {
		return skolska_godina;
	}

	public void setSkolska_godina(Skolska_godina skolska_godina) {
		this.skolska_godina = skolska_godina;
	}

	public List<Zaduzenja> getZaduzenjas() {
		return Zaduzenjas;
	}

	public void setZaduzenjas(List<Zaduzenja> zaduzenjas) {
		Zaduzenjas = zaduzenjas;
	}

	@Override
	public String toString() {
		return "Cenovnik [id=" + id + ", nazivStavke=" + nazivStavke + ", sifraStavke=" + sifraStavke + ", cenaStavke="
				+ cenaStavke + ", valuta=" + valuta + ", dateCreated=" + dateCreated + ", createdBy=" + createdBy
				+ ", dateModified=" + dateModified + ", modifiedBy=" + modifiedBy + ", modeli_placanja_i_stipendije="
				+ modeli_placanja_i_stipendije + ", skolska_godina=" + skolska_godina + ", Zaduzenjas=" + Zaduzenjas
				+ "]";
	}

}
