package com.clickbus.place.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Place {

	private @Id @GeneratedValue Long id;
	private String name;
	private String slug;
	private String city;
	private String state;
	@CreatedDate
	@Column(name="created_at")
	private Date createdAt;
	@LastModifiedDate
	@Column(name="update_at")
	private Date updateAt;

	public Place() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Place(Long id, String name, String slug, String city, String state, Date createdAt,
			Date updateAt) {
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.city = city;
		this.state = state;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}
	

}
