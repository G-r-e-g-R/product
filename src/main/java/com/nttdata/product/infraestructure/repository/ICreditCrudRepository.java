package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.infraestructure.model.dao.CreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
/**
 * ICREDITCRUDREPOSITORY.
 * Define las operaciones (CRUD) deL Credito (Credit)
 * el cual extiende del Reactive CRUD.
 */
public interface ICreditCrudRepository
        extends ReactiveCrudRepository<CreditDao, String> {
}
