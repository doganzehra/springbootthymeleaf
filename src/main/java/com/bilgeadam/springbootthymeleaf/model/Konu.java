package com.bilgeadam.springbootthymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Konu
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(nullable = false)
	private String NAME;

	public String getNAME()
	{
		return NAME;
	}

	public Long getID()
	{
		return ID;
	}

	public Konu(String nAME)
	{
		NAME = nAME;
	}
}
