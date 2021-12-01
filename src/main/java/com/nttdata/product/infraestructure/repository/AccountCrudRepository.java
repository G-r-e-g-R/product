package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.application.AccountRepository;
import com.nttdata.product.domain.Account;
import com.nttdata.product.infraestructure.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTCRUDREPOSITORY: Implementa las operaciones (CRUD) de la cuenta (Account)
 */
@Component
public class AccountCrudRepository implements AccountRepository {

    @Autowired
    IAccountCrudRepository repository;
    /*
    create: Regitra los datos de la cuenta
     */
    @Override
    public Mono<Account> create(Account account) {
        return repository.save(mapAccountToAccountDao(account))
                .map(this::mapAccountDaoToAccount);
    }
    /*
    update: Actualiza los datos de la cuenta
     */
    @Override
    public Mono<Account> update(String id, Account account) {
        return repository.findById(id)
                .flatMap( p ->create(mapAccountDaoToAccount(p,account)));
    }
    /*
    delete: Elimina los datos de la cuenta
     */
    @Override
    public Mono<AccountDao> delete(String id) {
        return repository.findById(id)
                .flatMap(p -> repository.deleteById(p.getId()).thenReturn(p));
    }
    /*
    findById: Busca por el Id los datos de la cuenta
     */
    @Override
    public Mono<Account> findById(String id) {
        return repository.findById( (id))
                .map( this::mapAccountDaoToAccount);
    }
    /*
    findAll: Busca  los datos de todas las cuentas
     */
    @Override
    public Flux<Account> findAll() {
        return repository.findAll()
                .map(this::mapAccountDaoToAccount);
    }
    /*
    mapAccountToAccountDao: Crea un clase AccountDao y asigna los datos de Account
     */
    private AccountDao mapAccountToAccountDao (Account account){
        AccountDao accountDao = new AccountDao();
        accountDao.setId(account.getId());
        accountDao.setAccountType(account.getAccountType());
        accountDao.setCommission(account.getCommission());
        accountDao.setLimitMovement(account.getLimitMovement());
        accountDao.setMinimumDailyAverageAmount(account.getMinimumDailyAverageAmount());
        accountDao.setName(account.getName());
        return accountDao;
    }
    /*
    mapAccountDaoToAccount: Crea una clase Account y asigna los datos de AccountDao
     */
    private Account mapAccountDaoToAccount (AccountDao accountDao){
        Account account = new Account();
        account.setId(accountDao.getId());
        account.setAccountType(accountDao.getAccountType());
        account.setCommission(accountDao.getCommission());
        account.setLimitMovement(accountDao.getLimitMovement());
        account.setMinimumDailyAverageAmount(accountDao.getMinimumDailyAverageAmount());
        account.setName(accountDao.getName());
        return account;
    }
    /*
    mapCustomerDaoToCustomer: Asigna el Id (Code) de CustomerDao a Customer
    */
    private Account mapAccountDaoToAccount (AccountDao accountDao,  Account account){
        account.setId(accountDao.getId());
        return account;
    }
}
