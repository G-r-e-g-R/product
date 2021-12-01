package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTOPERATIONSIMPL: Implementa las operaciones (CRUD) de las cuentas bancarias (Account)
 */
@Service
public class AccountOperationsImpl implements  AccountOperations{
    @Autowired
    AccountRepository repository;
    @Override
    public Mono<Account> create(Account account) {
        return repository.create(account);
    }

    @Override
    public Mono<Account> update(String id, Account account) {
        return repository.update(id, account);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Mono<Account> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Account> findAll() {
        return repository.findAll();
    }
}
