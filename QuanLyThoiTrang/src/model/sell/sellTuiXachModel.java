package model.sell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "order_history")

public class sellTuiXachModel {
	@Id
	private int order_id;
	private String order_date;
	private int tui_xach_id;

	public sellTuiXachModel() {
		super();
	}

	public sellTuiXachModel(String order_date, int tui_xach_id) {
		super();
		this.order_date = order_date;
		this.tui_xach_id = tui_xach_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getTui_xach_id() {
		return tui_xach_id;
	}

	public void setTui_xach_id(int tui_xach_id) {
		this.tui_xach_id = tui_xach_id;
	}

}
