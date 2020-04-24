package com.example.samleRestService;

import com.example.samleRestService.component.BankAccountBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SamleRestServiceApplicationTests {

	@Autowired
	BankAccountBean bankAccountBean;

	@Test
	void deposit_singleDeposit_correctBalance() {

		bankAccountBean.deposit(100);
		bankAccountBean.deposit(100);
		bankAccountBean.deposit(100);
		bankAccountBean.deposit(100);

		// Assert.
		int expected = 400;
		int actual = bankAccountBean.getBalance();
		Assertions.assertEquals(expected, actual);
	}

}
