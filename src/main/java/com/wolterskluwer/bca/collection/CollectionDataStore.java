package com.wolterskluwer.bca.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class CollectionDataStore {

	/** Generates a thread safe integer list ranging from 1-10000 */
	public List<Integer> getThreadSafeIntegerArrayList() {
		return IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
	}

	/** Generates a integer list ranging from 1-10000 */
	public List<Integer> getIntegerArrayList() {
		return IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(ArrayList::new));
	}

}
