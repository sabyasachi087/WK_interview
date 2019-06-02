# WK_interview
<b>Question 1.</b> Write a method to create a list of integer from 1 to 10000. Once the list is created, execute two threads parallelly. Thread 1 would remove all objects from the list that are < 5000 and thread 2 should remove all records > 500.

Once the list is empty, the method should output a message to the user indicating that the list is empty now

<b>Answer</b> Used a builder pattern to create a generic List removal method that accepts 'N' number of predicates and remove elements from the list as per the predicates using 'N' threads (Refer classes within 'com.wolterskluwer.bca.collection' package). As the question has two condition and two threads the Junit Class <b>TestBasicCollection.java</b> takes care of it.

<u> Execute JUnit <b>TestBasicCollection.java</b> .</u>

<b>Question 2.</b> Create a method interceptor using Spring AOP to log all the parameters passed for a method call in a class.

<b>Answer</b> Simple Spring AOP with @Before pointcut is used. Refer package 'com.wolterskluwer.bca.aop' for all details. The can be executed via Junit in <b>TestMathUtilAspect.java</b> class.

<u> Execute JUnit <b>TestMathUtilAspect.java</b> </u>

<b>Question 3.</b> Which of the statement is correct?

A) The JDBC module provides a JDBC-abstraction layer that removes the need to do tedious JDBC related coding. 
  
  <b>-> False.</b> JDBC module do provide abstarction layer but does not have implementation layer. JDBC drivers are required which actually contains the nitty-gritty of Database operations. Example of drivers : mysql-connector, oracle-jdbc (OJDBC) etc.

B) The ORM module provides integration layers for popular object-relational mapping APIs, including JPA, JDO, Hibernate, and iBatis.
  
  <b>-> True.</b> ORM modules like Hibernate/iBatis provides implementation layer, however JPA is only a specification and requires implementation layer like Hibernate, EclipseLink , iBatis etc. 

C) The Java Messaging Service JMS module contains features for producing and consuming messages. 
  
  <b>-> False.</b> Similar to JPA or JDBC, JMS is only a specification and does not contain any implementation. A JMS connector like activemq-jms, websphere-jms etc. is required to do the integration with coresponding messaging service.

# System Specifications
1. Open JDK 11
2. STS 4
3. Maven 3.6
