package com.example.adu_connect.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;




@Entity       
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	
	String userName;
	String surname;
	String nickname;
	String telefonNumarasi;
	String userSifre;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTelefonNumarasi() {
		return telefonNumarasi;
	}
	public void setTelefonNumarasi(String telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}
	public String getUserSifre() {
		return userSifre;
	}
	public void setUserSifre(String userSifre) {
		this.userSifre = userSifre;
	}


	
	
	
	
	
}
