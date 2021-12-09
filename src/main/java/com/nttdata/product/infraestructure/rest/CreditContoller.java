package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.CreditOperations;
import com.nttdata.product.domain.Credit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
 * CREDITCONTROLLER.
 * Publica las operaciones de los creditos (Credit)
 */
@Slf4j
@RestController
@RequestMapping("/products/credit")
@RequiredArgsConstructor
public class CreditContoller {
    /**
     * Operaciones del producto de crédito.
     */
    private final CreditOperations creditOperations;

    /**
     *  Busqueda de todos los productos de crédito.
     * @return Flux<Credit>
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<Credit>>> getAll() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(creditOperations.findAll()));
    }

    /**
     * Busqueda de un producto de crédito por Id.
     * @param id codigo.
     * @return Mono<Credit>
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Credit>> getById(@PathVariable final String id) {
        return creditOperations.findById(id)
                .map(c -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(c))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Registra un producto de crédito.
     * @param credit credito.
     * @return Mono<Credit>
     */
    @PostMapping
    public Mono<ResponseEntity<Credit>> post(@RequestBody final Credit credit) {
        return creditOperations.create(credit)
                .map(c -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(c))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Actualiza un producto de crédito.
     * @param id codigo.
     * @param credit credito.
     * @return Mono<Credit>
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Credit>> put(@PathVariable final String id,
                            @RequestBody final Credit credit) {
        return creditOperations.update(id, credit)
                .map(c -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(c))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Elimina un producto de crédito.
     * @param id codigo.
     */
    @DeleteMapping("/{id}")
    public  Mono<ResponseEntity<Void>> delete(@PathVariable final String id) {
        return creditOperations.delete(id)
                .map(c -> ResponseEntity
                        .noContent()
                        .<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
