package com.geo.todoapp.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="todomst")
public class Item {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="itemdesc")
    private String itemDesc;

    @Column(name="itemdate")
    private Date itemDate;

    @Column(name="status")
    private String status;


    // define constructors
    public Item() {

    }

    public Item(String itemDesc, Date itemDate, String status) {
        this.itemDesc = itemDesc;
        this.itemDate = itemDate;
        this.status = status;
    }
    
    // define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Date getItemDate() {
		return itemDate;
	}

	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}








