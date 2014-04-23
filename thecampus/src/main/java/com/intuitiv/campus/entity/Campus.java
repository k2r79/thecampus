package com.intuitiv.campus.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "campus", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id_campus") })
public class Campus {

	/**
	 * Unique Identifier
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_campus", unique = true, nullable = false)
	private Long id;

	/**
	 * Campus name
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Users of a campus
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_campus")
	private Set<User> users;

	public Campus(){

	}

	public Campus(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
