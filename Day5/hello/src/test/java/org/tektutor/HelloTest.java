package org.tektutor;

import static org.junit.Assert.*;
import org.junit.Test;

public class HelloTest {

	@Test
	public void testSayHello() {

		Hello hello = new Hello();

		String expectedResponse = "Hello Java !";
		String actualResponse   = hello.sayHello();

		assertEquals ( expectedResponse, actualResponse );
	}

}
