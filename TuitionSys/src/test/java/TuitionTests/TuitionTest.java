package TuitionTests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import TRMSservices.CategoryService;

public class TuitionTest {

	@Test
	public void refundAmount() {
	
	//Check if the proper refund amount is given
	int myRefund = CategoryService.getRefundAmount("Test Prep Course", 100);
	assertEquals(myRefund,75);
	
	}
}