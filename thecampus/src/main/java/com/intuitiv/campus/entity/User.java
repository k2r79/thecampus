package com.intuitiv.campus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	private Long id;

	/**
	 * Email of the user
	 */
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	/**
	 * Password of the user
	 */
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * Birth date of the user
	 */
	@Column(name = "birth", nullable = false)
	private Date birth;

	/**
	 * Name of the user
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * Surname of the user
	 */
	@Column(name = "surname", nullable = false)
	private String surname;

	/**
	 * User's sex boolean value
	 */
	@Column(name = "sex", nullable = false)
	private boolean sex;

	/**
	 * Url of the user picture
	 */
	@Column(name = "photo", nullable = true)
	private String photo;

	/**
	 * Campus of the user
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_campus")
	private Campus campus;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean getSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

}
