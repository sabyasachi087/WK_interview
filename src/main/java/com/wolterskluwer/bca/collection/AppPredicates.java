package com.wolterskluwer.bca.collection;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class AppPredicates {

	public Predicate<Integer> getLessThan5KPredicate() {
		return t -> t < 5000;
	}

	public Predicate<Integer> getGreaterThan5HundredPredicate() {
		return t -> t > 500;
	}

}
