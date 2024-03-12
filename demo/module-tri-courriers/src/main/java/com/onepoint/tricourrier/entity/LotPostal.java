package com.onepoint.tricourrier.entity;

import java.util.List;

public class LotPostal {

	private int id;
	private List<Courrier> courriers;

	public LotPostal(int id, List<Courrier> courriers) {
		this.id = id;
		this.courriers = courriers;
	}

	public int getId() {
		return id;
	}

	public List<Courrier> getCourriers() {
		return courriers;
	}

}
