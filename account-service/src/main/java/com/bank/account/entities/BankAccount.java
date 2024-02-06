package com.bank.account.entities;

import com.bank.account.enums.AccountType;
import com.bank.account.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

  @Id
  private String accountId;
  private double balance;
  private LocalDate createdAt;
  private String currency;
  @Enumerated(EnumType.STRING)
  private AccountType type;
  @Transient
  private Customer customer;
  private Long customerId;

}
