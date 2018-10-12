package com.gimnazijam.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "odeljenje")
public class Odeljenje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "odeljenje_id")
	private int id;

	@NotNull
	@Column(name = "oznaka")
	private int oznaka;

	@NotNull
	@Column(name = "razred")
	private String razred;

	// bi-directional many-to-many association to Angazovanje
	@ManyToMany(mappedBy = "odeljenjes")
	private List<Angazovanje> angazovanjes;

	// bi-directional many-to-one association to Nastavnik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nastavnik_id", nullable = false)
	private Nastavnik nastavnik;

	// bi-directional many-to-one association to Skolska_godina
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "skolska_godina_id", nullable = false)
	private Skolska_godina skolska_godina;

	// bi-directional many-to-one association to Upis
	@OneToMany(mappedBy = "odeljenje", cascade = CascadeType.ALL)
	private List<Upis> upiss;

	// bi-directional many-to-one association to Cas
	@OneToMany(mappedBy = "odeljenje", cascade = CascadeType.ALL)
	private List<Cas> cass;

	public Odeljenje() {

	}

	public Odeljenje(int id, @NotNull int oznaka, @NotNull String razred, List<Angazovanje> angazovanjes,
			Nastavnik nastavnik, Skolska_godina skolska_godina, List<Upis> upiss, List<Cas> cass) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.razred = razred;
		this.angazovanjes = angazovanjes;
		this.nastavnik = nastavnik;
		this.skolska_godina = skolska_godina;
		this.upiss = upiss;
		this.cass = cass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOznaka() {
		return oznaka;
	}

	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}

	public String getRazred() {
		return razred;
	}

	public void setRazred(String razred) {
		this.razred = razred;
	}

	public List<Angazovanje> getAngazovanjes() {
		return angazovanjes;
	}

	public void setAngazovanjes(List<Angazovanje> angazovanjes) {
		this.angazovanjes = angazovanjes;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Skolska_godina getSkolska_godina() {
		return skolska_godina;
	}

	public void setSkolska_godina(Skolska_godina skolska_godina) {
		this.skolska_godina = skolska_godina;
	}

	public List<Upis> getUpiss() {
		return upiss;
	}

	public void setUpiss(List<Upis> upiss) {
		this.upiss = upiss;
	}

	public List<Cas> getCass() {
		return cass;
	}

	public void setCass(List<Cas> cass) {
		this.cass = cass;
	}

	@Override
	public String toString() {
		return "Odeljenje [id=" + id + ", oznaka=" + oznaka + ", razred=" + razred + ", angazovanjes=" + angazovanjes
				+ ", nastavnik=" + nastavnik + ", skolska_godina=" + skolska_godina + ", upiss=" + upiss + ", cass="
				+ cass + "]";
	}

}
