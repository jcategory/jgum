package org.jgum.testutil.animalhierarchy;

import org.apache.log4j.or.ObjectRenderer;

public class AnimalRenderer implements ObjectRenderer {

	@Override
	public String doRender(Object animal) {
		return "animal";
	}

}
