package com.xebia.assessment.enums;

public enum ProductCategory {
	
	GROCERY("Grocery"), 
	FASHION("Fashion"), 
	SPORTS("Sports");
	
	
	private String displayName;

	
	private ProductCategory(String displayName) {
		this.displayName = displayName;
	}

	
	public String getDisplayName() {
		return displayName;
	}

	
	public int getValue() {
		return this.ordinal() + 1;
	}

	
	public static ProductCategory getByValue(int value) {
		return ProductCategory.values()[value - 1];
	}

	
	public String getLabel() {
		return this.toString();
	}

}
