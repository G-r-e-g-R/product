package com.nttdata.product.application;

import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITOPERATIONS.
 * Define las operaciones (CRUD) de los creditos (Credit)
 */
public interface CreditOperations {
    /**
     * Crea un producto de credito.
     * @param credit
     * @return Mono<Credit>
     */
    Mono<Credit> create(Credit credit);

    /**
     * Actualizar un producto de credito.
     * @param id
     * @param credit
     * @return Mono<Credit>
     */
    Mono<Credit> update(String id, Credit credit);

    /**
     * Elimina un producto de credito.
     * @param id
     * @return Mono<CreditDao>
     */
    Mono<CreditDao> delete(String id);

    /**
     * Búsqueda un producto de credito por Id.
     * @param id
     * @return Mono<Credit>
     */
    Mono<Credit> findById(String id);

    /**
     * Búsqueda de todos los productos de credito.
     * @return Flux<Credit>
     */
    Flux<Credit> findAll();
}
