package com.nttdata.product.infraestructure.repository;

import com.nttdata.product.application.AccountRepository;
import com.nttdata.product.domain.Account;
import com.nttdata.product.infraestructure.model.dao.AccountDao;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTCRUDREPOSITORY.
 * Implementa las operaciones (CRUD) de la cuenta (Account)
 */
@Component
public class AccountCrudRepository implements AccountRepository {

    /**
     * Repositorio del producto de cuenta bancaria.
     */
    private final IAccountCrudRepository repository;

    /**
     * Constructor.
     * @param iAccountCrudRepository
     */
    public AccountCrudRepository(
            final IAccountCrudRepository iAccountCrudRepository) {
        this.repository = iAccountCrudRepository;
    }
    /**
     * Regitra los datos de la cuenta.
     * @param account
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> create(final Account account) {
        return repository.save(mapAccountToAccountDao(account))
                .map(this::mapAccountDaoToAccount);
    }
    /**
     * Actualiza los datos de la cuenta.
     * @param id
     * @param account
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> update(final String id, final Account account) {
        return repository.findById(id)
                .flatMap(p -> create(mapAccountDaoToAccount(p, account)));
    }
    /**
     * Elimina los datos de la cuenta.
     * @param id
     * @return Mono<AccountDao>
     */
    @Override
    public Mono<Void> delete(final String id) {
        return repository.findById(id)
                .flatMap(p -> repository.delete(p));
    }
    /**
     * Busca por el Id los datos de la cuenta.
     * @param id
     * @return Mono<Account>
     */
    @Override
    public Mono<Account> findById(final String id) {
        return repository.findById((id))
                .map(this::mapAccountDaoToAccount);
    }
    /**
     * Busca  los datos de todas las cuentas.
     * @return Flux<Account>
     */
    @Override
    public Flux<Account> findAll() {
        return repository.findAll()
                .map(this::mapAccountDaoToAccount);
    }
    /**
     * Crea un clase AccountDao y asigna los datos de Account.
     * @param account
     * @return AccountDao
     */
    private AccountDao mapAccountToAccountDao(final Account account) {
        AccountDao accountDao = new AccountDao();
        BeanUtils.copyProperties(account, accountDao);
        return accountDao;
    }
    /**
     * Crea una clase Account y asigna los datos de AccountDao.
     * @param accountDao
     * @return Account
     */
    private Account mapAccountDaoToAccount(final AccountDao accountDao) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDao, account);
        return account;
    }
    /**
     * Asigna el Id (Code) de CustomerDao a Customer.
     * @param accountDao
     * @param account
     * @return Account
     */
    private Account mapAccountDaoToAccount(final AccountDao accountDao,
                                            final Account account) {
        account.setId(accountDao.getId());
        return account;
    }
}
