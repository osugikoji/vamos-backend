package com.vamos.domain.enums;

public enum DayEnum {

	MONDAY(1, "Segunda"),
	TUESDAY(2, "Terca"),
	WEDNESDAY(3, "Quarta"),
	THURSDAY(4, "Quinta"),
	FRIDAY(5, "Sexta"),
	SATURDAY(6, "Sabado"),
	SUNDAY(7, "Domingo");

	private int cod;
	private String description;

	private DayEnum(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static DayEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(DayEnum x : DayEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
