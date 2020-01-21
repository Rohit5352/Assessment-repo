package com.xebia.assessment.bizlayer;

public class DiscountUtility {

	public static Double getDiscount(Double baseAmount, Double discountRate) {
		
		int otherDiscountAmt = 0;
		int mulitpleOf100 = (int)(baseAmount/100);
		if(mulitpleOf100 > 0) {
			otherDiscountAmt = mulitpleOf100 * 5;
		}
		
		Double discountAmount = (discountRate/100)*baseAmount;
		return baseAmount - (discountAmount+otherDiscountAmt);
	}
	
}
