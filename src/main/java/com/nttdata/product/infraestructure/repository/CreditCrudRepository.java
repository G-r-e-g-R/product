package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.application.CreditRepository;
import com.nttdata.product.domain.Credit;
import com.nttdata.product.infraestructure.model.dao.CreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITCRUDREPOSITORY: Implementa las operaciones (CRUD) de los creditos (Credit)
 */
@Component
public class CreditCrudRepository implements CreditRepository {
    @Autowired
    ICreditCrudRepository repository;
    /*
    create: Regitra los datos del credito
     */
    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.save(mapCreditToCreditDao(credit))
                .map(this::mapCreditDaoToCredit);
    }
    /*
    update: Actualiza los datos del credito
     */
    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.findById(id)
                .flatMap( p ->create(mapCreditDaoToCredit(p,credit)));
    }
    /*
    delete: Elimina los datos del credito
     */
    @Override
    public Mono<CreditDao> delete(String id) {
        return repository.findById(id)
                .flatMap(p -> repository.deleteById(p.getId()).thenReturn(p));
    }
    /*
    findById: Busca por el Id los datos de un credito
     */
    @Override
    public Mono<Credit> findById(String id) {
        return repository.findById( (id))
                .map( this::mapCreditDaoToCredit);
    }
    /*
    findAll: Busca  los datos de todos  los credito
     */
    @Override
    public Flux<Credit> findAll() {
        return repository.findAll()
                .map(this::mapCreditDaoToCredit);
    }

    /*
    mapCreditToCreditDao: Crea un clase CreditDao y asigna los datos de Credit
     */
    private CreditDao mapCreditToCreditDao (Credit credit){
        CreditDao creditDao = new CreditDao();
        creditDao.setCardNumber(credit.getCardNumber());
        creditDao.setCreditType(credit.getCreditType());
        creditDao.setId(credit.getId());
        creditDao.setMaximumNumberCredit(credit.getMaximumNumberCredit());
        return creditDao;
    }
    /*
    mapCreditDaoToCredit: Crea un clase CreditDao y asigna los datos de Credit
     */
    private Credit mapCreditDaoToCredit (CreditDao creditDao){
        Credit credit = new Credit();
        credit.setCardNumber(creditDao.getCardNumber());
        credit.setCreditType(creditDao.getCreditType());
        credit.setId(creditDao.getId());
        credit.setMaximumNumberCredit(creditDao.getMaximumNumberCredit());
        return credit;
    }
    /*
    mapCreditDaoToCredit: Asigna el Id de CreditDao a Credit
    */
    private Credit mapCreditDaoToCredit (CreditDao creditDao,  Credit credit){
        credit.setId(creditDao.getId());
        return credit;
    }
}
