package com.wolterskluwer.bca.aop;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MathUtilAspect {

	private static final Logger LOGGER = LogManager.getLogger(MathUtilAspect.class);

	@Before("execution (* com.wolterskluwer.bca.aop.MathUtility.sum(..))")
	public void before(JoinPoint joinPoint) {
		BigInteger[] biArgs = (BigInteger[]) joinPoint.getArgs()[0];
		List<String> args = Arrays.asList(biArgs).stream().map(BigInteger::toString).collect(Collectors.toList());
		LOGGER.info("Sum method of MathUtility has been invoked with params {}", String.join(",", args));
	}

}
