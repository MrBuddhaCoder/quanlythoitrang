package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "quan")
public class quanModel {
	@Id
	private int id;
	private String loai_quan;
	private String color;
	private String brand;

	public quanModel() {
		super();
	}

	public quanModel(int id, String loai_quan, String color, String brand) {
		super();
		this.id = id;
		this.loai_quan = loai_quan;
		this.color = color;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoai_quan() {
		return loai_quan;
	}

	public void setLoai_quan(String loai_quan) {
		this.loai_quan = loai_quan;
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

}
