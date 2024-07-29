package com.java.finalProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bills")
public class Bill {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long billId;
	 	@ManyToOne
	    @JoinColumn(name = "tableId", referencedColumnName = "tableId")
	    private tables table;
	 	private double totalPrice;
	 	private Date date;
	 	
	 	@OneToMany(mappedBy = "bills") // mappedBy sẽ trỏ đến tên trường User trong lớp Order
		@JsonBackReference
		private List<DetailBill> detailBill = new ArrayList<>();
	 	
	 	
		public List<DetailBill> getDetailBill() {
			return detailBill;
		}
		public void setDetailBill(List<DetailBill> detailBill) {
			this.detailBill = detailBill;
		}
		public Long getBillId() {
			return billId;
		}
		public void setBillId(Long billId) {
			this.billId = billId;
		}
		public tables getTable() {
			return table;
		}
		public void setTable(tables table) {
			this.table = table;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
	 	
	 	
}
