package com.nttdata.product.application;

import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITREPOSITORY: Define las operaciones en la BD para los Creditos (Credit)
 */
public interface CreditRepository {
    public Mono<Credit> create(Credit credit);
    public Mono<Credit> update(String id, Credit credit);
    public Mono<CreditDao> delete(String id);
    public Mono<Credit> findById(String id);
    public Flux<Credit> findAll();
}
