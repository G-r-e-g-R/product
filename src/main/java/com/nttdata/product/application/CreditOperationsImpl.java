package com.nttdata.product.application;

import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITOPERATIONSIMPL.
 * Implementa las operaciones (CRUD) de los creditos (Credit)
 */
@Service
public class CreditOperationsImpl implements CreditOperations {
    /**
     * Repositorio del producto de credito.
     */
    private final CreditRepository repository;

    /**
     * Constructor.
     * @param creditRepository
     */
    public CreditOperationsImpl(final CreditRepository creditRepository) {
        this.repository = creditRepository;
    }

    /**
     * Crea un producto de credito.
     * @param credit
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> create(final Credit credit) {
        return repository.create(credit);
    }

    /**
     * Actualiza un producto de credito.
     * @param id
     * @param credit
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> update(final String id, final Credit credit) {
        return repository.update(id, credit);
    }

    /**
     * Elimina un producto de credito.
     * @param id
     * @return Mono<CreditDao>
     */
    @Override
    public Mono<CreditDao> delete(final String id) {
        return repository.delete(id);
    }

    /**
     * Búsqueda de un producto de credito por Id.
     * @param id
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> findById(final String id) {
        return repository.findById(id);
    }

    /**
     * Búsqueda de todos los productos de credito.
     * @return Flux<Credit>
     */
    @Override
    public Flux<Credit> findAll() {
        return repository.findAll();
    }
}
