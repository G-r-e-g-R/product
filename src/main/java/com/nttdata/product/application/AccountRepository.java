package com.nttdata.product.application;

import com.nttdata.product.domain.Account;
import com.nttdata.product.infraestructure.model.dao.AccountDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTREPOSITORY.
 * Define las operaciones en la BD para las cuentas bancarias (Account)
 */
public interface AccountRepository {
    /**
     * Crea un producto de cuenta bancaria.
     * @param account
     * @return  Mono<Account>
     */
    Mono<Account> create(Account account);

    /**
     * Actualiza un producto de cuenta bancaria.
     * @param id
     * @param account
     * @return  Mono<Account>
     */
    Mono<Account> update(String id, Account account);

    /**
     * Elimina un producto de cuenta bancaria.
     * @param id
     * @return Mono<AccountDao>
     */
    Mono<AccountDao> delete(String id);

    /**
     * Búsqueda de un producto de cuenta bancaria.
     * @param id
     * @return  Mono<Account>
     */
    Mono<Account> findById(String id);

    /**
     * Búsqueda de todos productos de cuenta bancaria.
     * @return Flux<Account>
     */
    Flux<Account> findAll();
}
