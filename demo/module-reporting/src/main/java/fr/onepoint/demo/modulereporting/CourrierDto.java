package fr.onepoint.demo.modulereporting;

class CourrierDto {
	private Integer codePostal;
	private String ville;

	public CourrierDto(Integer codePostal, String ville) {
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
