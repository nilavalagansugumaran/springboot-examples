package com.nila.itv.testSimpleApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestSimpleAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TestSimpleAppApplication.class, args);

		//Traditionally
//		MyComponent c = new MyComponent();
//		c.sayHello();

		//Accessing a bean from container
		MyComponent component = context.getBean(MyComponent.class);
		component.sayHello();
		//Accessing all beans of type
		component.sayHelloFromAllService();
		//Access application args
		component.printApplicationArgs();


		MyService service = context.getBean(MyService.class);
		service.sayHelloFromService();

		// Two classes implementing the interface - TWO Qualifying beans
//		MyInterface myInterface = context.getBean(MyInterface.class);
//		myInterface.sayHelloFromService();

		MyInterface myInterface = (MyInterface)context.getBean("myOtherService"); // access by name
		myInterface.sayHelloFromService();
	}

}
