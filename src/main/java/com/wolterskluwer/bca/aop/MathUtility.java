package com.wolterskluwer.bca.aop;

import java.math.BigInteger;

public interface MathUtility {

	/** Add function */
	public BigInteger sum(BigInteger... bigIntegers);

	/** Converts celsius to farenheit */
	public double toFarenheit(double tempInCelsius);

	/** Converts celsius to farenheit */
	public double toCelsius(double tempInFarenheit);

}
