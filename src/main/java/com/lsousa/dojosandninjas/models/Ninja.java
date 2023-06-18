package com.lsousa.dojosandninjas.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ninjas")
public class Ninja {

// ========== Primary Key ===================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

// ========== Member Variables ==============

	 @NotNull
	 @Size(min=1, message="Please enter the ninja's first name")
	 private String firstName;
	
	 @NotNull
	 @Size(min=1, message="Please enter the ninja's last name")
	 private String lastName;
	
	 @NotNull
	 @Min(value=1, message="Please enter a valid age")
	 private Integer age;

// ========== Data Creation Trackers ========

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

// ========== Relationships =================

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

// ========== Constructors ==================

// Empty constructor
	public Ninja() {}

// ========== Data Creation Event ===========

	@PrePersist
	protected void onCreate() {
	    this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdated() {
	    this.updatedAt = new Date();
	}

//========== Getters and Setters ===========
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Dojo getDojo() {
		return dojo;
	}
	
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

}