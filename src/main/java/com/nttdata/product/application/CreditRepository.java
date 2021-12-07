package com.nttdata.product.application;

import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITREPOSITORY.
 * Define las operaciones en la BD para los Creditos (Credit)
 */
public interface CreditRepository {
    /**
     * Crea un producto de credito.
     * @param credit
     * @return Mono<Credit>
     */
    Mono<Credit> create(Credit credit);

    /**
     * Actualiza un producto de credito.
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
     * Búsqueda de un producto de credito por Id.
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
