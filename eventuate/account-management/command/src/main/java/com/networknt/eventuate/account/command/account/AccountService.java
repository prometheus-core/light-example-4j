package com.networknt.eventuate.account.command.account;




import com.networknt.eventuate.common.AggregateRepository;
import com.networknt.eventuate.common.EntityWithIdAndVersion;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class AccountService  {

  private final AggregateRepository<Account, AccountCommand> accountRepository;

  public AccountService(AggregateRepository<Account, AccountCommand> accountRepository) {
    this.accountRepository = accountRepository;
  }

  public CompletableFuture<EntityWithIdAndVersion<Account>> openAccount(String customerId, String title, BigDecimal initialBalance, String description) {
    return accountRepository.save(new OpenAccountCommand(customerId, title, initialBalance, description));
  }

  public CompletableFuture<EntityWithIdAndVersion<Account>> deleteAccount(String accountId) {
    return accountRepository.update(accountId, new DeleteAccountCommand());
  }
}
