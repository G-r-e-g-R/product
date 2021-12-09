package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTOPERATIONSIMPL.
 * Implementa las operaciones (CRUD) de las cuentas bancarias (Account)
 */
@Service
public class AccountOperationsImpl implements  AccountOperations {
    /**
     * Repositorio del producto de cuenta bancaria.
     */
    private final AccountRepository repository;

    /**
     * Constructor.
     * @param accountRepository
     */
    public AccountOperationsImpl(final AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    /**
     * Crea un producto de cuenta bancaria.
     * @param account
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> create(final Account account) {
        return repository.create(account);
    }

    /**
     * Actualiza un producto de cuenta bancaria.
     * @param id
     * @param account
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> update(final String id, final Account account) {
        return repository.update(id, account);
    }

    /**
     * Elimina un producto de cuenta bancaria.
     * @param id
     */
    @Override
    public Mono<Void> delete(final String id) {
        return repository.delete(id);
    }

    /**
     * Busqueda de un producto de cuenta bancaria por Id.
     * @param id
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> findById(final String id) {
        return repository.findById(id);
    }

    /**
     * Búsqueda de todos los productos de cuenta bancaria.
     * @return Flux<Account>
     */
    @Override
    public Flux<Account> findAll() {
        return repository.findAll();
    }
}
