package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "ao")
public class aoModel {
	@Id
	private int id;
	private String loai_ao;
	private String color;
	private String brand;

	public aoModel() {
		super();
	}

	public aoModel(int id, String loai_ao, String color, String brand) {
		super();
		this.id = id;
		this.loai_ao = loai_ao;
		this.color = color;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoai_ao() {
		return loai_ao;
	}

	public void setLoai_ao(String loai_ao) {
		this.loai_ao = loai_ao;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "aoModel [id=" + id + ", loai_ao=" + loai_ao + ", color=" + color + ", brand=" + brand + "]";
	}

}
