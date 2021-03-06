package org.jcategory.category;

/**
 * A listener notified when a category has been added to a categorization.
 * @author sergioc
 *
 * @param <T> the type of the category
 */
public interface CategorizationListener<T extends Category> {

	/**
	 * Callback method invoked when a category has been added to a categorization.
	 * @param category the category added to a categorization.
	 */
	public void onCategorization(T category);
	
}
