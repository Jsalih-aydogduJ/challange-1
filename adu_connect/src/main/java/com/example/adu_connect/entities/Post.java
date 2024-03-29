package com.example.adu_connect.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId",nullable=false)

	@OnDelete(action= OnDeleteAction.CASCADE)
	User user;
	
	
	
	
	
	String title;

	@Lob
	@Column(columnDefinition = "TEXT")
	String icerik;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	
	
	
	
	
	
	
}
