package com.bios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "Contacto", indexes = {
		@Index(name = "Publishers_Names",
				columnList = "AuthorName")})
public class Author implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuthorId")
	private Long id;
	//TODO: Mapear columna de nombre indicando que no pueda ser nula
	private String name;
	@Column(name = "EmailAddress", nullable = false)
	private String emailAddress;

	public Author() {
	}

	public Author(String name, String emailAddress) {
		this.name = name;
		this.emailAddress = emailAddress;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + '}';
	}
}
