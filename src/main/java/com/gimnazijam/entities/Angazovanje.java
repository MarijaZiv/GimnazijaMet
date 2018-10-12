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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "angazovanje")
public class Angazovanje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "angazovanje_id")
	private int id;

	@NotNull
	@Column(name = "pocetak")
	private Date pocetak;

	@Column(name = "kraj")
	private Date kraj;

	// bi-directional many-to-many association to Odeljenje
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "angazovanje_odeljenje", joinColumns = @JoinColumn(name = "angazovanje_id"), inverseJoinColumns = @JoinColumn(name = "odeljenje_id"))
	private List<Odeljenje> odeljenjes;

	// bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavnik_id", nullable = false)
	private Nastavnik nastavnik;

	// bi-directional many-to-one association to Nastavni_plan_predmet
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavni_plan_predmet_id", nullable = false)
	private Nastavni_plan_predmet nastavni_plan_predmet;

	public Angazovanje() {

	}

	public Angazovanje(int id, @NotNull Date pocetak, Date kraj, List<Odeljenje> odeljenjes, Nastavnik nastavnik,
			Nastavni_plan_predmet nastavni_plan_predmet) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.odeljenjes = odeljenjes;
		this.nastavnik = nastavnik;
		this.nastavni_plan_predmet = nastavni_plan_predmet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	public Date getKraj() {
		return kraj;
	}

	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}

	public List<Odeljenje> getOdeljenjes() {
		return odeljenjes;
	}

	public void setOdeljenjes(List<Odeljenje> odeljenjes) {
		this.odeljenjes = odeljenjes;
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

	@Override
	public String toString() {
		return "Angazovanje [id=" + id + ", pocetak=" + pocetak + ", kraj=" + kraj + ", odeljenjes=" + odeljenjes
				+ ", nastavnik=" + nastavnik + ", nastavni_plan_predmet=" + nastavni_plan_predmet + "]";
	}

}
