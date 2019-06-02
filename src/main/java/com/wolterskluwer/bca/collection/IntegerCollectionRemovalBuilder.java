package com.wolterskluwer.bca.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegerCollectionRemovalBuilder<T> {

	private static final Logger LOGGER = LogManager.getLogger(IntegerCollectionRemovalBuilder.class);

	private List<Predicate<T>> predicates = new ArrayList<>();

	public IntegerCollectionRemovalBuilder<T> addPredicate(Predicate<T> predicate) {
		this.predicates.add(predicate);
		return this;
	}

	/**
	 * A copy of the list data will be used for implementation other than
	 * {@link CopyOnWriteArrayList}
	 * 
	 * @return List<T> data after removing all matching (Predicate) values
	 */
	public List<T> build(List<T> data) {
		if (!(data instanceof CopyOnWriteArrayList)) {
			data = new CopyOnWriteArrayList<>(data);
		}
		if (this.predicates.isEmpty()) {
			throw new IllegalArgumentException("Please add predicate before invoking build");
		}
		this.perform(data);
		return data;
	}

	/**
	 * This method removes data from the list by creating a new thread for each
	 * predicate and performing {@link List##removeIf(Predicate)}
	 */
	private void perform(List<T> data) {
		try {
			ExecutorService executors = Executors.newFixedThreadPool(this.predicates.size());
			List<Runnable> tasks = new ArrayList<>();
			this.predicates.forEach(p -> tasks.add(() -> data.removeIf(p)));
			tasks.forEach(executors::submit);
			executors.shutdown();
			int countRetry = 5;
			do {
				executors.awaitTermination(5, TimeUnit.SECONDS);
				if (countRetry == 0) {
					LOGGER.warn("Executor is taking longer than usual ... ");
					throw new RuntimeException("Could not complete execution within given time");
				}
				countRetry--;
			} while (!executors.isShutdown());
		} catch (Exception ex) {
			LOGGER.error("Error performing multi thread list removal .. ", ex);
		}
	}

}
