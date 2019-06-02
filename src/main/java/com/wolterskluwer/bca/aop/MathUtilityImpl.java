package com.wolterskluwer.bca.aop;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MathUtilityImpl implements MathUtility {

	public BigInteger sum(BigInteger... bigIntegers) {
		BigInteger sum = BigInteger.valueOf(0);
		for (BigInteger b : Arrays.asList(bigIntegers)) {
			sum = sum.add(b);
		}
		return sum;
	}

	public double toFarenheit(double tempInCelsius) {
		return ((9d / 5d) * tempInCelsius) + 32;
	}

	public double toCelsius(double tempInFarenheit) {
		return (tempInFarenheit - 32) * (5d / 9d);
	}

}
