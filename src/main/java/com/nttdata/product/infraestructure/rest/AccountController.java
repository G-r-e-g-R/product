package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.AccountOperations;
import com.nttdata.product.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTCONTROLLER.
 * Publica las operaciones de las cuentas bancarias (Account)
 */
@Slf4j
@RestController
@RequestMapping("/products/account")
@RequiredArgsConstructor
public class AccountController {
    /**
     * Operaciones del producto de cuenta bancaria.
     */
    private final AccountOperations accountOperations;

    /**
     * Busqueda de todos los productos de cuentas bancarias.
     * @return Flux<Account>
     */
    @GetMapping
    public Flux<Account> getAll() {
        return accountOperations.findAll();
    }

    /**
     * Busqueda de un producto de cuenta bancaria por Id.
     * @param id
     * @return Mono<Account>
     */
    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable final String id) {
        return accountOperations.findById(id);
    }

    /**
     * Registro de un producto de cuenta bancaria.
     * @param account
     * @return Mono<Account>
     */
    @PostMapping
    public Mono<Account> post(@RequestBody final Account account) {
        return accountOperations.create(account);
    }

    /**
     * Actualiza un producto de cuenta bancaria.
     * @param id
     * @param account
     * @return Mono<Account>
     */
    @PutMapping("/{id}")
    public Mono<Account> put(@PathVariable final String id,
                             @RequestBody final Account account) {
        return accountOperations.update(id, account);
    }

    /**
     * Elimina un producto de cuenta bancaria.
     * @param id
     */
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable final String id) {
        accountOperations.delete(id);
    }
}
