package org.tektutor;

public class Hello {

	public Hello() {}

	public String sayHello() {
		return "Hello Java !";
	}

	public static void main ( String[] args ) {

		Hello hello = new Hello();
		System.out.println ( hello.sayHello() );

	}

}
