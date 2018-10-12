package com.gimnazijam.entities;

import java.sql.Timestamp;
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
@Table(name = "zaduzenja")
public class Zaduzenja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zaduzenja_id")
	private int id;

	@Column(name = "iznos_zaduzenja")
	private Double iznosZaduzenja;

	@NotNull
	@Column(name = "rok_za_placanje")
	private Date rokZaPlacanje;

	@Column(name = "popust_iznos")
	private Double popustIznos;

	@Column(name = "napomena")
	private String napomena;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "modified_by")
	private int modifiedBy;

	@Column(name = "date_modified")
	private Timestamp dateModified;

	// bi-directional many-to-one association to Cenovnik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cenovnik_id", nullable = false)
	private Cenovnik cenovnik;

	// bi-directional many-to-one association to Upis
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "upis_id", nullable = false)
	private Upis upis;

	// bi-directional many-to-one association to Uplate
	@OneToMany(mappedBy = "zaduzenja", cascade = CascadeType.ALL)
	private List<Uplate> uplates;

	public Zaduzenja() {

	}

	public Zaduzenja(int id, Double iznosZaduzenja, @NotNull Date rokZaPlacanje, Double popustIznos, String napomena,
			int createdBy, Timestamp dateCreated, int modifiedBy, Timestamp dateModified, Cenovnik cenovnik, Upis upis,
			List<Uplate> uplates) {
		super();
		this.id = id;
		this.iznosZaduzenja = iznosZaduzenja;
		this.rokZaPlacanje = rokZaPlacanje;
		this.popustIznos = popustIznos;
		this.napomena = napomena;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.modifiedBy = modifiedBy;
		this.dateModified = dateModified;
		this.cenovnik = cenovnik;
		this.upis = upis;
		this.uplates = uplates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getIznosZaduzenja() {
		return iznosZaduzenja;
	}

	public void setIznosZaduzenja(Double iznosZaduzenja) {
		this.iznosZaduzenja = iznosZaduzenja;
	}

	public Date getRokZaPlacanje() {
		return rokZaPlacanje;
	}

	public void setRokZaPlacanje(Date rokZaPlacanje) {
		this.rokZaPlacanje = rokZaPlacanje;
	}

	public Double getPopustIznos() {
		return popustIznos;
	}

	public void setPopustIznos(Double popustIznos) {
		this.popustIznos = popustIznos;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public Upis getUpis() {
		return upis;
	}

	public void setUpis(Upis upis) {
		this.upis = upis;
	}

	public List<Uplate> getUplates() {
		return uplates;
	}

	public void setUplates(List<Uplate> uplates) {
		this.uplates = uplates;
	}

	@Override
	public String toString() {
		return "Zaduzenja [id=" + id + ", iznosZaduzenja=" + iznosZaduzenja + ", rokZaPlacanje=" + rokZaPlacanje
				+ ", popustIznos=" + popustIznos + ", napomena=" + napomena + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", modifiedBy=" + modifiedBy + ", dateModified=" + dateModified
				+ ", cenovnik=" + cenovnik + ", upis=" + upis + ", uplates=" + uplates + "]";
	}

}
