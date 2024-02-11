package com.bank.account.repositories;

import com.bank.account.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    BankAccount findBankAccountByAccountId(String id);
}
