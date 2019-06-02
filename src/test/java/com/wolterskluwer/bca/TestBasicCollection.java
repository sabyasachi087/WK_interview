package com.wolterskluwer.bca;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.wolterskluwer.bca.collection.AppPredicates;
import com.wolterskluwer.bca.collection.CollectionDataStore;
import com.wolterskluwer.bca.collection.IntegerCollectionRemovalBuilder;

@EnableAutoConfiguration
public class TestBasicCollection extends BaseTestTemplate {

	private static final Logger LOGGER = LogManager.getLogger(TestBasicCollection.class);

	@Autowired
	private AppPredicates predicates;

	@Autowired
	private CollectionDataStore dataStore;

	@Test
	public void test() {
		List<Integer> integerDataList = this.dataStore.getIntegerArrayList();
		IntegerCollectionRemovalBuilder<Integer> builder = new IntegerCollectionRemovalBuilder<>();
		integerDataList = builder.addPredicate(this.predicates.getGreaterThan5HundredPredicate())
				.addPredicate(this.predicates.getLessThan5KPredicate()).build(integerDataList);

		Assert.assertTrue("List is not empty", integerDataList.size() == 0);
		LOGGER.info("List has been cleared");
	}

	@Test
	public void testThreadSafe() {
		List<Integer> integerDataList = this.dataStore.getThreadSafeIntegerArrayList();
		IntegerCollectionRemovalBuilder<Integer> builder = new IntegerCollectionRemovalBuilder<>();
		integerDataList = builder.addPredicate(this.predicates.getLessThan5KPredicate())
				.addPredicate(this.predicates.getGreaterThan5HundredPredicate()).build(integerDataList);

		Assert.assertTrue("List is not empty", integerDataList.size() == 0);
		LOGGER.info("List has been cleared");
	}

}
