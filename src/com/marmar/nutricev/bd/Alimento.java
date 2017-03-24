package com.marmar.nutricev.bd;

public class Alimento {

	private int _id;
	private String nombre;
	private String unidad_medida;
	private float cantidad;

	public Alimento() {
		super();
	}

	public Alimento(int _id, String nombre, String unidad_medida) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.unidad_medida = unidad_medida;
	}

	public Alimento(int _id, String nombre, String unidad_medida, float cantidad) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.unidad_medida = unidad_medida;
		this.cantidad = cantidad;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return nombre + ", " + unidad_medida;
	}

}
