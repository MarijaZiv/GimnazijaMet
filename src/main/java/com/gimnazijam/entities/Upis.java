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
@Table(name = "upis")
public class Upis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "upis_id")
	private int id;

	@NotNull
	@Column(name = "datum_upisa")
	private Date datumUpisa;

	// bi-directional many-to-one association to Ucenik
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ucenik_id", nullable = false)
	private Ucenik ucenik;

	// bi-directional many-to-one association to Odeljenje
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "odeljenje_id", nullable = false)
	private Odeljenje odeljenje;

	// bi-directional many-to-one association to Zaduzenja
	@OneToMany(mappedBy = "upis", cascade = CascadeType.ALL)
	private List<Zaduzenja> zaduzenjas;

	public Upis() {

	}

	public Upis(int id, @NotNull Date datumUpisa, Ucenik ucenik, Odeljenje odeljenje, List<Zaduzenja> zaduzenjas) {
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.ucenik = ucenik;
		this.odeljenje = odeljenje;
		this.zaduzenjas = zaduzenjas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public List<Zaduzenja> getZaduzenjas() {
		return zaduzenjas;
	}

	public void setZaduzenjas(List<Zaduzenja> zaduzenjas) {
		this.zaduzenjas = zaduzenjas;
	}

	@Override
	public String toString() {
		return "Upis [id=" + id + ", datumUpisa=" + datumUpisa + ", ucenik=" + ucenik + ", odeljenje=" + odeljenje
				+ ", zaduzenjas=" + zaduzenjas + "]";
	}

}
