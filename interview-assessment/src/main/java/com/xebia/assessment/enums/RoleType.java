package com.xebia.assessment.enums;

public enum RoleType {

	EMPLOYEE("Employee"),
	CUSTOMER("Customer"), 
	AFFILIATE_USER("AffiliateUser");
	
	
	
	private String displayName;

	
	private RoleType(String displayName) {
		this.displayName = displayName;
	}

	
	public String getDisplayName() {
		return displayName;
	}

	
	public int getValue() {
		return this.ordinal() + 1;
	}

	
	public static RoleType getByValue(int value) {
		return RoleType.values()[value - 1];
	}

	
	public String getLabel() {
		return this.toString();
	}
}
