package com.example.coffeeshop.domain;

public enum ProductType {
	BREAKFAST("BREAKFAST"),LUNCH("LUNCH"),DINNER("DINNER");

	private final String displayName;

	ProductType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
