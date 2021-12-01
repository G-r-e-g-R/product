package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTOPERATIONS: Define las operaciones (CRUD) de las cuentas bancarias (Account)
 */
public interface AccountOperations {
    public Mono<Account> create(Account account);
    public Mono<Account> update(String id, Account account);
    public void delete(String id);
    public Mono<Account> findById(String id);
    public Flux<Account> findAll();
}
