package com.bank.account.rest;

import com.bank.account.entities.BankAccount;
import com.bank.account.repositories.BankAccountRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

  private final BankAccountRepository bankAccountRepository;

  public BankAccountController(BankAccountRepository bankAccountRepository) {
    this.bankAccountRepository = bankAccountRepository;
  }


  @GetMapping("/accounts")
  public List<BankAccount> accountList() {
   return   this.bankAccountRepository.findAll();
  }

  @GetMapping("/accounts/{id}")
  public BankAccount getAccountById(String id) {
    return this.bankAccountRepository.findById(id).get();
  }
}
