package com.example.samleRestService.component;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BankAccountBean {

    private String name;
    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

}
