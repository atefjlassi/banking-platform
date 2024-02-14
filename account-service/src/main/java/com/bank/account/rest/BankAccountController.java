package com.bank.account.rest;

import com.bank.account.clients.CustomerClient;
import com.bank.account.entities.BankAccount;
import com.bank.account.model.Customer;
import com.bank.account.repositories.BankAccountRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerClient customerClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerClient customerClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerClient = customerClient;
    }


    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> accounts = this.bankAccountRepository.findAll();
        accounts.forEach(bankAccount -> {
            Customer customer = this.customerClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);
        });
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable("id") String id) {
        BankAccount bankAccount = this.bankAccountRepository.findBankAccountByAccountId(id);
        Customer customer = this.customerClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);

        return bankAccount;
    }
}
