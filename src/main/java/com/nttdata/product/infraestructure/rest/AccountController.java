package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.AccountOperations;
import com.nttdata.product.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<Flux<Account>>> getAll() {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(accountOperations.findAll()));
    }

    /**
     * Busqueda de un producto de cuenta bancaria por Id.
     * @param id codigo.
     * @return Mono<Account>
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Account>> getById(@PathVariable final String id) {
        return accountOperations.findById(id)
                .map(customer -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customer))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Registro de un producto de cuenta bancaria.
     * @param account cuenta bancaria.
     * @return Mono<Account>
     */
    @PostMapping
    public Mono<ResponseEntity<Account>> post(@RequestBody final Account account) {
        return accountOperations.create(account)
                .map(c -> ResponseEntity.status(HttpStatus.OK).body(c))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Actualiza un producto de cuenta bancaria.
     * @param id codigo.
     * @param account cuenta bancaria.
     * @return Mono<Account>
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Account>> put(@PathVariable final String id,
                             @RequestBody final Account account) {
        return accountOperations.update(id, account)
                .map(acc -> ResponseEntity.status(HttpStatus.OK).body(acc))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Elimina un producto de cuenta bancaria.
     * @param id codigo.
     */
    @DeleteMapping("/{id}")
    public  Mono<ResponseEntity<Void>> delete(@PathVariable final String id) {
        return accountOperations.delete(id)
                .map(acc -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
