package com.wolterskluwer.bca;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.wolterskluwer.bca.aop.MathUtility;

@EnableAutoConfiguration
public class TestMathUtilAspect extends BaseTestTemplate {

	@Autowired
	private MathUtility mathUtility;

	@Test
	public void testLogAspect() throws Exception {
		this.mathUtility = Mockito.spy(this.mathUtility);
		BigInteger[] args = { BigInteger.valueOf(125), BigInteger.valueOf(6515), BigInteger.valueOf(5621) };
		BigInteger sum = this.mathUtility.sum(args);
		Assert.assertEquals(sum, BigInteger.valueOf(125 + 6515 + 5621));
	}

}
