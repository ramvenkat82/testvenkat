package com.dnb;

import junit.framework.TestCase;

public class TestBeanTest extends TestCase {

	public void testIsValidCompanyId() {
		assertTrue("Valid CompanyId", com.dnb.TestBean.isValidCompanyId(600000));
		//assertFalse("Valid CompanyId", com.dnb.TestBean.isValidCompanyId(700000));
	}

}
