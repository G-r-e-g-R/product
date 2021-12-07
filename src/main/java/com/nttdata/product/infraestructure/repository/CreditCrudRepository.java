package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.application.CreditRepository;
import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITCRUDREPOSITORY.
 * Implementa las operaciones (CRUD) de los creditos (Credit)
 */
@Component
public class CreditCrudRepository implements CreditRepository {
    /**
     * Repositorio del producto de crédito.
     */
    private final ICreditCrudRepository repository;

    /**
     * Constructor.
     * @param iCreditCrudRepository
     */
    public CreditCrudRepository(
            final ICreditCrudRepository iCreditCrudRepository) {
        this.repository = iCreditCrudRepository;
    }
    /**
     * Regitra los datos del credito.
     * @param credit
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> create(final Credit credit) {
        return repository.save(mapCreditToCreditDao(credit))
                .map(this::mapCreditDaoToCredit);
    }
    /**
     * Actualiza los datos del credito.
     * @param id
     * @param credit
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> update(final String id, final Credit credit) {
        return repository.findById(id)
                .flatMap(p -> create(mapCreditDaoToCredit(p, credit)));
    }
    /**
     * Elimina los datos del credito.
     * @param id
     * @return Mono<CreditDao>
     */
    @Override
    public Mono<CreditDao> delete(final String id) {
        return repository.findById(id)
                .flatMap(p -> repository.deleteById(p.getId()).thenReturn(p));
    }
    /**
     * Busca por el Id los datos de un credito.
     * @param id
     * @return Mono<Credit>
     */
    @Override
    public Mono<Credit> findById(final String id) {
        return repository.findById((id))
                .map(this::mapCreditDaoToCredit);
    }
    /**
     * Busca  los datos de todos  los credito.
     * @return Flux<Credit>
     */
    @Override
    public Flux<Credit> findAll() {
        return repository.findAll()
                .map(this::mapCreditDaoToCredit);
    }
    /**
     * Crea un clase CreditDao y asigna los datos de Credit.
     * @param credit
     * @return CreditDao
     */
    private CreditDao mapCreditToCreditDao(final Credit credit) {
        CreditDao creditDao = new CreditDao();
        BeanUtils.copyProperties(credit, creditDao);
        return creditDao;
    }
    /**
     * Crea un clase CreditDao y asigna los datos de Credit.
     * @param creditDao
     * @return Credit
     */
    private Credit mapCreditDaoToCredit(final CreditDao creditDao) {
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditDao, credit);
        return credit;
    }
    /**
     * Asigna el Id de CreditDao a Credit.
     * @param creditDao
     * @param credit
     * @return Credit
     */
    private Credit mapCreditDaoToCredit(final CreditDao creditDao,
                                         final Credit credit) {
        credit.setId(creditDao.getId());
        return credit;
    }
}
