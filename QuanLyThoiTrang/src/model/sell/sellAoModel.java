package model.sell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "order_history")
public class sellAoModel {
	@Id
	private int order_id;
	private String order_date;
	private int ao_id;

	public sellAoModel() {
		super();
	}

	public sellAoModel(String order_date, int ao_id) {
		super();
		this.order_date = order_date;
		this.ao_id = ao_id;
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

}
