package model.sell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_history")
public class orderHistoryModel {
	@Id
	private int order_id;
	private String order_date;
	
	private int ao_id;
	private int quan_id;
	private int tui_xach_id;
	

	public orderHistoryModel() {
		super();
	}

	public orderHistoryModel(String order_date, int ao_id, int quan_id, int tui_xach_id) {
		super();
		this.order_date = order_date;
		this.ao_id = ao_id;
		this.quan_id = quan_id;
		this.tui_xach_id = tui_xach_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getAo_id() {
		return ao_id;
	}

	public void setAo_id(int ao_id) {
		this.ao_id = ao_id;
	}

	public int getQuan_id() {
		return quan_id;
	}

	public void setQuan_id(int quan_id) {
		this.quan_id = quan_id;
	}

	public int getTui_xach_id() {
		return tui_xach_id;
	}

	public void setTui_xach_id(int tui_xach_id) {
		this.tui_xach_id = tui_xach_id;
	}

}
