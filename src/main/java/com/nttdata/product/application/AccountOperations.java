package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTOPERATIONS.
 * Define las operaciones (CRUD) de las cuentas bancarias (Account)
 */
public interface AccountOperations {
    /**
     * Crea un producto de cuenta bancaria.
     * @param account
     * @return Mono<Account>
     */
    Mono<Account> create(Account account);

    /**
     * Actualiza un producto de cuenta bancaria.
     * @param id
     * @param account
     * @return Mono<Account>
     */
    Mono<Account> update(String id, Account account);

    /**
     * Elimina un producto de cuenta bancaria.
     * @param id
     */
    void delete(String id);

    /**
     * Búsqueda de un producto de cuenta bancaria por Id.
     * @param id
     * @return Mono<Account>
     */
    Mono<Account> findById(String id);

    /**
     * Búsqueda de todos los productos de cuenta bancaria.
     * @return Flux<Account>
     */
    Flux<Account> findAll();
}
