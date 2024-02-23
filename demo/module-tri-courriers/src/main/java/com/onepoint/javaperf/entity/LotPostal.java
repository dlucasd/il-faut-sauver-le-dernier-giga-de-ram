package com.onepoint.javaperf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
public class LotPostal {

	@Id
	private int id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lotPostal")
	@Fetch(FetchMode.SUBSELECT)
	private List<Courrier> courriers;

	public int getId() {
		return id;
	}

	public List<Courrier> getCourriers() {
		return courriers;
	}

}
