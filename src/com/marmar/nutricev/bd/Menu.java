package com.marmar.nutricev.bd;

public class Menu {

	private Alimento id_lacteos;
	private Alimento id_aoa;
	private Alimento id_aceites;
	private Alimento id_frutas;
	private Alimento id_verduras;
	private Alimento id_azucares;
	private Alimento id_cereales;
	private Alimento id_leguminosas;
	private int dia_semana;
	private int dia;
	private int mes;
	private int anyo;
	private String comida;

	private String cant_lacteo;
	private String cant_fruta;
	private String cant_verduras;
	private String cant_azucares;
	private String cant_legumbres;
	private String cant_cereales;
	private String cant_aoa;
	private String cant_aceites;

	public Menu() {
		super();
	}

	public Menu(Alimento id_lacteos, Alimento id_aoa, Alimento id_aceites,
			Alimento id_frutas, Alimento id_verduraz, Alimento id_azucares,
			Alimento id_cereales, Alimento id_leguminosas) {
		super();
		this.id_lacteos = id_lacteos;
		this.id_aoa = id_aoa;
		this.id_aceites = id_aceites;
		this.id_frutas = id_frutas;
		this.id_verduras = id_verduraz;
		this.id_azucares = id_azucares;
		this.id_cereales = id_cereales;
		this.id_leguminosas = id_leguminosas;
	}

	public Menu(Alimento id_lacteos, Alimento id_aoa, Alimento id_aceites,
			Alimento id_frutas, Alimento id_verduraz, Alimento id_azucares,
			Alimento id_cereales, Alimento id_leguminosas, int dia, int mes,
			int anyo, String comida) {
		super();
		this.id_lacteos = id_lacteos;
		this.id_aoa = id_aoa;
		this.id_aceites = id_aceites;
		this.id_frutas = id_frutas;
		this.id_verduras = id_verduraz;
		this.id_azucares = id_azucares;
		this.id_cereales = id_cereales;
		this.id_leguminosas = id_leguminosas;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.comida = comida;
	}

	public Alimento getId_lacteos() {
		return id_lacteos;
	}

	public void setId_lacteos(Alimento id_lacteos) {
		this.id_lacteos = id_lacteos;
	}

	public Alimento getId_aoa() {
		return id_aoa;
	}

	public void setId_aoa(Alimento id_aoa) {
		this.id_aoa = id_aoa;
	}

	public Alimento getId_aceites() {
		return id_aceites;
	}

	public void setId_aceites(Alimento id_aceites) {
		this.id_aceites = id_aceites;
	}

	public Alimento getId_frutas() {
		return id_frutas;
	}

	public void setId_frutas(Alimento id_frutas) {
		this.id_frutas = id_frutas;
	}

	public Alimento getId_verduras() {
		return id_verduras;
	}

	public void setId_verduras(Alimento id_verduraz) {
		this.id_verduras = id_verduraz;
	}

	public Alimento getId_azucares() {
		return id_azucares;
	}

	public void setId_azucares(Alimento id_azucares) {
		this.id_azucares = id_azucares;
	}

	public Alimento getId_cereales() {
		return id_cereales;
	}

	public void setId_cereales(Alimento id_cereales) {
		this.id_cereales = id_cereales;
	}

	public Alimento getId_leguminosas() {
		return id_leguminosas;
	}

	public void setId_leguminosas(Alimento id_leguminosas) {
		this.id_leguminosas = id_leguminosas;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}

	public int getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(int dia_semana) {
		this.dia_semana = dia_semana;
	}

	public String getCant_lacteo() {
		return cant_lacteo;
	}

	public void setCant_lacteo(String cant_lacteo) {
		this.cant_lacteo = cant_lacteo;
	}

	public String getCant_fruta() {
		return cant_fruta;
	}

	public void setCant_fruta(String cant_fruta) {
		this.cant_fruta = cant_fruta;
	}

	public String getCant_verduras() {
		return cant_verduras;
	}

	public void setCant_verduras(String cant_verduras) {
		this.cant_verduras = cant_verduras;
	}

	public String getCant_azucares() {
		return cant_azucares;
	}

	public void setCant_azucares(String cant_azucares) {
		this.cant_azucares = cant_azucares;
	}

	public String getCant_legumbres() {
		return cant_legumbres;
	}

	public void setCant_legumbres(String cant_legumbres) {
		this.cant_legumbres = cant_legumbres;
	}

	public String getCant_cereales() {
		return cant_cereales;
	}

	public void setCant_cereales(String cant_cereales) {
		this.cant_cereales = cant_cereales;
	}

	public String getCant_aoa() {
		return cant_aoa;
	}

	public void setCant_aoa(String cant_aoa) {
		this.cant_aoa = cant_aoa;
	}

	public String getCant_aceites() {
		return cant_aceites;
	}

	public void setCant_aceites(String cant_aceites) {
		this.cant_aceites = cant_aceites;
	}

	@Override
	public String toString() {
		return "Menu [id_lacteos=" + id_lacteos + ", id_aoa=" + id_aoa
				+ ", id_aceites=" + id_aceites + ", id_frutas=" + id_frutas
				+ ", id_verduraz=" + id_verduras + ", id_azucares="
				+ id_azucares + ", id_cereales=" + id_cereales
				+ ", id_leguminosas=" + id_leguminosas + ", dia=" + dia
				+ ", mes=" + mes + ", anyo=" + anyo + ", comida=" + comida
				+ "]";
	}

}