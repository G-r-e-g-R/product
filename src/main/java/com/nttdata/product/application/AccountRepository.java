package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import com.nttdata.product.infraestructure.model.dao.AccountDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTREPOSITORY: Define las operaciones en la BD para las cuentas bancarias (Account)
 */
public interface AccountRepository {
    public Mono<Account> create(Account account);
    public Mono<Account> update(String id, Account account);
    public Mono<AccountDao> delete(String id);
    public Mono<Account> findById(String id);
    public Flux<Account> findAll();
}
