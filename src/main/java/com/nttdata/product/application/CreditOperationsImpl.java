package com.nttdata.product.application;

import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITOPERATIONSIMPL: Implementa las operaciones (CRUD) de los creditos (Credit)
 */
@Service
public class CreditOperationsImpl implements CreditOperations{
    @Autowired
    CreditRepository repository;
    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.create(credit);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.update(id, credit);
    }

    @Override
    public Mono<CreditDao> delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Mono<Credit> findById(String id) {
        return repository.findById(id);
    }


    @Override
    public Flux<Credit> findAll() {
        return repository.findAll();
    }
}
