package org.jgum.category;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdHocCategorizationTutorialTest {

	@Test
	public void testSimpleHierarchy() {
		//creating a simple categorization
		Category grandFather = new Category(new Categorization<>()); //the root of the hierarchy
		Category parent1 = new Category(asList(grandFather)); //parent1 inherits from grandFather
		Category parent2 = new Category(asList(grandFather)); //parent2 also inherits from grandFather
		Category child = new Category(asList(parent1, parent2)); //child inherits from both parent1 and parent2
		
		//setting properties
		grandFather.setProperty("p1", "x"); //setting property "p1" to "x" in grandFather
		parent1.setProperty("p1", "y"); //overridden property "p1" as "y" in parent1
		parent2.setProperty("p1", "z"); //overridden property "p1" as "z" in parent2
		parent2.setProperty("p2", "x"); //setting property "p2" to "x" in parent2
		
		//testing
		assertEquals("y", child.getProperty("p1").get()); //"p1" property found in parent1
		assertEquals("x", child.getProperty("p2").get()); //"p2" property found in parent2
	}
}
