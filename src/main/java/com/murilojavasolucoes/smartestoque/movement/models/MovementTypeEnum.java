package com.murilojavasolucoes.smartestoque.movement.models;

public enum MovementTypeEnum {

	SALES("Venda"), //
	SHOPPING("Compra"), //
	BUDGET("Orçamento"), //
	PENDENT("Suspensa");//

	private String name;

	private MovementTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
