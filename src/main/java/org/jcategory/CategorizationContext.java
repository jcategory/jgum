package org.jcategory;

import java.util.HashMap;
import java.util.Map;

import org.jcategory.category.Categorization;
import org.jcategory.category.Category;

/**
 * Defines a register of categorizations.
 * @author sergioc
 *
 */
public class CategorizationContext {

	private final Map<Object, Categorization<?>> categorizationIndex; //categorizations are backed up in this map.
	
	public CategorizationContext () {
		categorizationIndex = new HashMap<>();
	}
	
	/**
	 * @param key the key under which the requested categorization is registered.
	 * @return the categorization registered under the key sent as a parameter.
	 */
	public <T extends Category> Categorization<T> getCategorization(Object key) {
		return (Categorization<T>) categorizationIndex.get(key);
	}
	
	/**
	 * Adds a new categorization to the register.
	 * @param key the key under which the given categorization will be registered.
	 * @param categorization  the categorization to register under the key sent as a parameter.
	 */
	public void register(Object key, Categorization<?> categorization) {
		categorizationIndex.put(key, categorization);
	}

}
