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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "godisnji_plan")
public class Godisnji_plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "godisnji_plan_id")
	private int id;

	@Column(name = "naziv_skole")
	private String nazivSkole;

	@NotNull
	@Column(name = "usvojen")
	private int usvojen;

	@NotNull
	@Column(name = "datum_usvajanja")
	private Date datumUsvajanja;

	@NotNull
	@Column(name = "vazi_do")
	private Date vaziDo;

	// bi-directional many-to-one association to Skolska_godina
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "skolska_godina_id", nullable = false)
	private Skolska_godina skolska_godina;

	// bi-directional many-to-one association to Nastavni_plan_predmet
	@OneToMany(mappedBy = "godisnji_plan", cascade = CascadeType.ALL)
	private List<Nastavni_plan_predmet> nastavni_plan_predmets;

	public Godisnji_plan() {

	}

	public Godisnji_plan(int id, String nazivSkole, @NotNull int usvojen, @NotNull Date datumUsvajanja,
			@NotNull Date vaziDo, Skolska_godina skolska_godina, List<Nastavni_plan_predmet> nastavni_plan_predmets) {
		super();
		this.id = id;
		this.nazivSkole = nazivSkole;
		this.usvojen = usvojen;
		this.datumUsvajanja = datumUsvajanja;
		this.vaziDo = vaziDo;
		this.skolska_godina = skolska_godina;
		this.nastavni_plan_predmets = nastavni_plan_predmets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivSkole() {
		return nazivSkole;
	}

	public void setNazivSkole(String nazivSkole) {
		this.nazivSkole = nazivSkole;
	}

	public int getUsvojen() {
		return usvojen;
	}

	public void setUsvojen(int usvojen) {
		this.usvojen = usvojen;
	}

	public Date getDatumUsvajanja() {
		return datumUsvajanja;
	}

	public void setDatumUsvajanja(Date datumUsvajanja) {
		this.datumUsvajanja = datumUsvajanja;
	}

	public Date getVaziDo() {
		return vaziDo;
	}

	public void setVaziDo(Date vaziDo) {
		this.vaziDo = vaziDo;
	}

	public Skolska_godina getSkolska_godina() {
		return skolska_godina;
	}

	public void setSkolska_godina(Skolska_godina skolska_godina) {
		this.skolska_godina = skolska_godina;
	}

	public List<Nastavni_plan_predmet> getNastavni_plan_predmets() {
		return nastavni_plan_predmets;
	}

	public void setNastavni_plan_predmets(List<Nastavni_plan_predmet> nastavni_plan_predmets) {
		this.nastavni_plan_predmets = nastavni_plan_predmets;
	}

	@Override
	public String toString() {
		return "Godisnji_plan [id=" + id + ", nazivSkole=" + nazivSkole + ", usvojen=" + usvojen + ", datumUsvajanja="
				+ datumUsvajanja + ", vaziDo=" + vaziDo + ", skolska_godina=" + skolska_godina
				+ ", nastavni_plan_predmets=" + nastavni_plan_predmets + "]";
	}

}
