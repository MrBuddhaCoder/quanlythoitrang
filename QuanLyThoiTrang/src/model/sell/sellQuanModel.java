package model.sell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "order_history")

public class sellQuanModel {

	@Id
	private int order_id;
	private String order_date;
	private int quan_id;

	public sellQuanModel() {
		super();
	}

	public sellQuanModel(String order_date, int quan_id) {
		super();
		this.order_date = order_date;
		this.quan_id = quan_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getQuan_id() {
		return quan_id;
	}

	public void setQuan_id(int quan_id) {
		this.quan_id = quan_id;
	}

}
