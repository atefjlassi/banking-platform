package com.bank.account;

import com.bank.account.entities.BankAccount;
import com.bank.account.enums.AccountType;
import com.bank.account.repositories.BankAccountRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountServiceApplication.class, args);
  }

  CommandLineRunner commandLineRunner(BankAccountRepository repository) {
    return args -> {
      List<BankAccount> list = List.of(
        BankAccount.builder().accountId(UUID.randomUUID().toString()).balance(2500)
          .createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).customerId(Long.valueOf(1))
          .build(),
        BankAccount.builder().accountId(UUID.randomUUID().toString()).balance(400)
          .createdAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(Long.valueOf(1))
          .build(),
        BankAccount.builder().accountId(UUID.randomUUID().toString()).balance(1822)
          .createdAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).customerId(Long.valueOf(2))
          .build()
        );

      repository.saveAll(list);
    };
  }
}
