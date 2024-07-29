package com.java.finalProject.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "areas")
public class areas {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long areaId;
	private String areaName;
	private String description;
	@OneToMany(mappedBy = "area") // mappedBy sẽ trỏ đến tên trường User trong lớp Order
	@JsonBackReference
	private List<tables> tables = new ArrayList<>();
	
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public List<tables> getTables() {
		return tables;
	}
	public void setTables(List<tables> tables) {
		this.tables = tables;
	}
	
	
}
