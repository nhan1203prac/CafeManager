package com.java.finalProject.model;



import java.util.ArrayList;
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
@Table(name = "tables")
public class tables {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	private String tableName;
	private String status;
	@ManyToOne
    @JoinColumn(name = "areaId", referencedColumnName = "areaId")
    private areas area;
	
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public areas getArea() {
		return area;
	}
	public void setArea(areas area) {
		this.area = area;
	}
	
	
	
}
