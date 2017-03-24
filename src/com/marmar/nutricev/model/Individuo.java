package com.marmar.nutricev.model;

public class Individuo {

	private static Individuo singleton = new Individuo();
	
	public static Individuo getInstance(){
		return singleton;
	}
	
	private double peso;
	private double talla;
	private double pesoIdeal;
	private double pesoCorregido;
	private double gastoEnergetio;
	private double edad;
	private double eta;
	private double actividadFisica;
	private double gebEta;
	private double imc;

	public Individuo() {

	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public double getPesoIdeal() {
		return pesoIdeal;
	}

	public void setPesoIdeal(double pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}

	public double getPesoCorregido() {
		return pesoCorregido;
	}

	public void setPesoCorregido(double pesoCorregido) {
		this.pesoCorregido = pesoCorregido;
	}

	public double getGastoEnergetio() {
		return gastoEnergetio;
	}

	public void setGastoEnergetio(double gastoEnergetio) {
		this.gastoEnergetio = gastoEnergetio;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public double getEta() {
		return eta;
	}

	public void setEta(double eta) {
		this.eta = eta;
	}

	public double getActividadFisica() {
		return actividadFisica;
	}

	public void setActividadFisica(double actividadFisica) {
		this.actividadFisica = actividadFisica;
	}

	public double getGebEta() {
		return gebEta;
	}

	public void setGebEta(double gebEta) {
		this.gebEta = gebEta;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

}
