package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.AccountOperations;
import com.nttdata.product.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ACCOUNTCONTROLLER: Publica las operaciones de las cuentas bancarias (Account)
 */
@Slf4j
@RestController
@RequestMapping("/products/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountOperations accountOperations;

    @GetMapping
    public Flux<Account> getAll(){
        return accountOperations.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable String id){
        return accountOperations.findById(id);
    }
    @PostMapping
    public Mono<Account> post(@RequestBody Account account){
        return accountOperations.create(account);
    }
    @PutMapping("/{id}")
    public Mono<Account> put(@PathVariable String id, @RequestBody Account account){
        return accountOperations.update(id, account);
    }
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable String id){
        accountOperations.delete(id);
    }
}
