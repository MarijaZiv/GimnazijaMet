package com.gimnazijam.entities;

import java.util.Date;
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
@Table(name = "skolska_godina")
public class Skolska_godina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skolska_godina_id")
	private int id;

	@NotNull
	@Column(name = "datum_pocetka")
	private Date datumPocetka;

	@NotNull
	@Column(name = "datum_kraja")
	private Date datumKraja;

	// bi-directional many-to-one association to Cenovnik
	@OneToMany(mappedBy = "skolska_godina", cascade = CascadeType.ALL)
	private List<Cenovnik> cenovniks;

	// bi-directional many-to-one association to Odeljenje
	@OneToMany(mappedBy = "skolska_godina", cascade = CascadeType.ALL)
	private List<Odeljenje> odeljenjes;

	// bi-directional many-to-one association to Godisnji_plan
	@OneToMany(mappedBy = "skolska_godina", cascade = CascadeType.ALL)
	private List<Godisnji_plan> godisnji_plans;

	public Skolska_godina() {

	}

	public Skolska_godina(int id, @NotNull Date datumPocetka, @NotNull Date datumKraja, List<Cenovnik> cenovniks,
			List<Odeljenje> odeljenjes, List<Godisnji_plan> godisnji_plans) {
		super();
		this.id = id;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.cenovniks = cenovniks;
		this.odeljenjes = odeljenjes;
		this.godisnji_plans = godisnji_plans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public List<Cenovnik> getCenovniks() {
		return cenovniks;
	}

	public void setCenovniks(List<Cenovnik> cenovniks) {
		this.cenovniks = cenovniks;
	}

	public List<Odeljenje> getOdeljenjes() {
		return odeljenjes;
	}

	public void setOdeljenjes(List<Odeljenje> odeljenjes) {
		this.odeljenjes = odeljenjes;
	}

	public List<Godisnji_plan> getGodisnji_plans() {
		return godisnji_plans;
	}

	public void setGodisnji_plans(List<Godisnji_plan> godisnji_plans) {
		this.godisnji_plans = godisnji_plans;
	}

	@Override
	public String toString() {
		return "Skolska_godina [id=" + id + ", datumPocetka=" + datumPocetka + ", datumKraja=" + datumKraja
				+ ", cenovniks=" + cenovniks + ", odeljenjes=" + odeljenjes + ", godisnji_plans=" + godisnji_plans
				+ "]";
	}

}
