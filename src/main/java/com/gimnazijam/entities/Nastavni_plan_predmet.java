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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nastavni_plan_predmet")
public class Nastavni_plan_predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nastavni_plan_predmet_id")
	private int id;

	@NotNull
	@Column(name = "ime_plana")
	private String imePlana;

	@NotNull
	@Column(name = "razred")
	private String razred;

	@NotNull
	@Column(name = "nedeljno_nastave")
	private int nedeljnoNastave;

	@NotNull
	@Column(name = "nedeljno_vezbi")
	private int nedeljnoVezbi;

	@NotNull
	@Column(name = "ukupno_nedelja")
	private int ukupnoNedelja;

	// bi-directional many-to-one association to Predmet
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "predmet_id", nullable = false)
	private Predmet predmet;

	// bi-directional many-to-one association to Godisnji_plan
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "godisnji_plan_id", nullable = false)
	private Godisnji_plan godisnji_plan;

	// bi-directional many-to-one association to Angazovanje
	@OneToMany(mappedBy = "nastavni_plan_predmet", cascade = CascadeType.ALL)
	private List<Angazovanje> angazovanjes;

	// bi-directional many-to-one association to Cas
	@OneToMany(mappedBy = "nastavni_plan_predmet", cascade = CascadeType.ALL)
	private List<Cas> cass;

	public Nastavni_plan_predmet() {

	}

	public Nastavni_plan_predmet(int id, @NotNull String imePlana, @NotNull String razred, @NotNull int nedeljnoNastave,
			@NotNull int nedeljnoVezbi, @NotNull int ukupnoNedelja, Predmet predmet, Godisnji_plan godisnji_plan,
			List<Angazovanje> angazovanjes, List<Cas> cass) {
		super();
		this.id = id;
		this.imePlana = imePlana;
		this.razred = razred;
		this.nedeljnoNastave = nedeljnoNastave;
		this.nedeljnoVezbi = nedeljnoVezbi;
		this.ukupnoNedelja = ukupnoNedelja;
		this.predmet = predmet;
		this.godisnji_plan = godisnji_plan;
		this.angazovanjes = angazovanjes;
		this.cass = cass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImePlana() {
		return imePlana;
	}

	public void setImePlana(String imePlana) {
		this.imePlana = imePlana;
	}

	public String getRazred() {
		return razred;
	}

	public void setRazred(String razred) {
		this.razred = razred;
	}

	public int getNedeljnoNastave() {
		return nedeljnoNastave;
	}

	public void setNedeljnoNastave(int nedeljnoNastave) {
		this.nedeljnoNastave = nedeljnoNastave;
	}

	public int getNedeljnoVezbi() {
		return nedeljnoVezbi;
	}

	public void setNedeljnoVezbi(int nedeljnoVezbi) {
		this.nedeljnoVezbi = nedeljnoVezbi;
	}

	public int getUkupnoNedelja() {
		return ukupnoNedelja;
	}

	public void setUkupnoNedelja(int ukupnoNedelja) {
		this.ukupnoNedelja = ukupnoNedelja;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Godisnji_plan getGodisnji_plan() {
		return godisnji_plan;
	}

	public void setGodisnji_plan(Godisnji_plan godisnji_plan) {
		this.godisnji_plan = godisnji_plan;
	}

	public List<Angazovanje> getAngazovanjes() {
		return angazovanjes;
	}

	public void setAngazovanjes(List<Angazovanje> angazovanjes) {
		this.angazovanjes = angazovanjes;
	}

	public List<Cas> getCass() {
		return cass;
	}

	public void setCass(List<Cas> cass) {
		this.cass = cass;
	}

	@Override
	public String toString() {
		return "Nastavni_plan_predmet [id=" + id + ", imePlana=" + imePlana + ", razred=" + razred
				+ ", nedeljnoNastave=" + nedeljnoNastave + ", nedeljnoVezbi=" + nedeljnoVezbi + ", ukupnoNedelja="
				+ ukupnoNedelja + ", predmet=" + predmet + ", godisnji_plan=" + godisnji_plan + ", angazovanjes="
				+ angazovanjes + ", cass=" + cass + "]";
	}

}
