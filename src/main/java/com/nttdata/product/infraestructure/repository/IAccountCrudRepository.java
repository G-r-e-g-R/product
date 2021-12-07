package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.infraestructure.model.dao.AccountDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
/**
 * IACCOUNTCRUDREPOSITORY.
 * Define las operaciones (CRUD) de la cuenta (Account)
 * el cual extiende del Reactive CRUD.
 */
public interface IAccountCrudRepository
        extends ReactiveCrudRepository<AccountDao, String> {
}
