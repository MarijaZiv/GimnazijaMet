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
@Table(name = "zaposleni")
public class Zaposleni {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zaposleni_id")
	private int id;

	@NotNull
	@Column(name = "zvanje")
	private String zvanje;

	@NotNull
	@Column(name = "SSS")
	private String sss;

	@NotNull
	@Column(name = "pozicija")
	private String pozicija;

	@Column(name = "banka")
	private String banka;

	@Column(name = "broj_racuna")
	private String brojRacuna;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// bi-directional many-to-one association to Nastavnik
	@OneToMany(mappedBy = "zaposleni", cascade = CascadeType.ALL)
	private List<Nastavnik> nastavniks;

	// bi-directional many-to-one association to Roditeljski_sastanak
	@OneToMany(mappedBy = "zaposleni", cascade = CascadeType.ALL)
	private List<Roditeljski_sastanak> roditeljski_sastanaks;

	public Zaposleni() {

	}

	public Zaposleni(int id, @NotNull String zvanje, @NotNull String sss, @NotNull String pozicija, String banka,
			String brojRacuna, User user, List<Nastavnik> nastavniks,
			List<Roditeljski_sastanak> roditeljski_sastanaks) {
		super();
		this.id = id;
		this.zvanje = zvanje;
		this.sss = sss;
		this.pozicija = pozicija;
		this.banka = banka;
		this.brojRacuna = brojRacuna;
		this.user = user;
		this.nastavniks = nastavniks;
		this.roditeljski_sastanaks = roditeljski_sastanaks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public String getSss() {
		return sss;
	}

	public void setSss(String sss) {
		this.sss = sss;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	public String getBanka() {
		return banka;
	}

	public void setBanka(String banka) {
		this.banka = banka;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Nastavnik> getNastavniks() {
		return nastavniks;
	}

	public void setNastavniks(List<Nastavnik> nastavniks) {
		this.nastavniks = nastavniks;
	}

	public List<Roditeljski_sastanak> getRoditeljski_sastanaks() {
		return roditeljski_sastanaks;
	}

	public void setRoditeljski_sastanaks(List<Roditeljski_sastanak> roditeljski_sastanaks) {
		this.roditeljski_sastanaks = roditeljski_sastanaks;
	}

	@Override
	public String toString() {
		return "Zaposleni [id=" + id + ", zvanje=" + zvanje + ", sss=" + sss + ", pozicija=" + pozicija + ", banka="
				+ banka + ", brojRacuna=" + brojRacuna + ", user=" + user + ", nastavniks=" + nastavniks
				+ ", roditeljski_sastanaks=" + roditeljski_sastanaks + "]";
	}

}
