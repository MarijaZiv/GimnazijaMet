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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@NotNull
	@Column(name = "ime")
	private String ime;

	@NotNull
	@Column(name = "prezime")
	private String prezime;

	@Column(name = "JMBG")
	private String jmbg;

	@NotNull
	@Column(name = "datum_rodjenja")
	private Date datumRodjenja;

	@NotNull
	@Column(name = "adresa")
	private String adresa;

	@NotNull
	@Column(name = "grad")
	private String grad;

	@Column(name = "telefon")
	private String telefon;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "LDAPON")
	private String ldapon;

	@Column(name = "email")
	private String email;

	// bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	// bi-directional many-to-one association to Roditelj
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Roditelj> roditeljs;

	// bi-directional many-to-one association to Zaposleni
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Zaposleni> zaposlenis;

	// bi-directional many-to-one association to Ucenik
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Ucenik> uceniks;

	public User() {

	}

	public User(int id, @NotNull String ime, @NotNull String prezime, String jmbg, @NotNull Date datumRodjenja,
			@NotNull String adresa, @NotNull String grad, String telefon, String displayName, String username,
			String password, String ldapon, String email, List<Role> roles, List<Roditelj> roditeljs,
			List<Zaposleni> zaposlenis, List<Ucenik> uceniks) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.grad = grad;
		this.telefon = telefon;
		this.displayName = displayName;
		this.username = username;
		this.password = password;
		this.ldapon = ldapon;
		this.email = email;
		this.roles = roles;
		this.roditeljs = roditeljs;
		this.zaposlenis = zaposlenis;
		this.uceniks = uceniks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLdapon() {
		return ldapon;
	}

	public void setLdapon(String ldapon) {
		this.ldapon = ldapon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Roditelj> getRoditeljs() {
		return roditeljs;
	}

	public void setRoditeljs(List<Roditelj> roditeljs) {
		this.roditeljs = roditeljs;
	}

	public List<Zaposleni> getZaposlenis() {
		return zaposlenis;
	}

	public void setZaposlenis(List<Zaposleni> zaposlenis) {
		this.zaposlenis = zaposlenis;
	}

	public List<Ucenik> getUceniks() {
		return uceniks;
	}

	public void setUceniks(List<Ucenik> uceniks) {
		this.uceniks = uceniks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", datumRodjenja="
				+ datumRodjenja + ", adresa=" + adresa + ", grad=" + grad + ", telefon=" + telefon + ", displayName="
				+ displayName + ", username=" + username + ", password=" + password + ", ldapon=" + ldapon + ", email="
				+ email + ", roles=" + roles + ", roditeljs=" + roditeljs + ", zaposlenis=" + zaposlenis + ", uceniks="
				+ uceniks + "]";
	}

}
