package com.onepoint.javaperf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class LotPostal {

	@Id
	private int id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lotPostal")
	private Set<Courrier> courriers;

	public int getId() {
		return id;
	}

	public Set<Courrier> getCourriers() {
		return courriers;
	}

}
