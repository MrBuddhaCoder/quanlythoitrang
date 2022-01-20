package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "tui_xach")
public class tuiXachModel {
	@Id
	private int id;
	private String loai_tui_xach;
	private String color;
	private String brand;

	public tuiXachModel() {
		super();
	}

	public tuiXachModel(int id, String loai_tui_xach, String color, String brand) {
		super();
		this.id = id;
		this.loai_tui_xach = loai_tui_xach;
		this.color = color;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoai_tui_xach() {
		return loai_tui_xach;
	}

	public void setLoai_tui_xach(String loai_tui_xach) {
		this.loai_tui_xach = loai_tui_xach;
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
