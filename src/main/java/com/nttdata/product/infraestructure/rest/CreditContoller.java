package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.CreditOperations;
import com.nttdata.product.domain.Credit;
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
    public Flux<Credit> getAll() {
        return creditOperations.findAll();
    }

    /**
     * Busqueda de un producto de crédito por Id.
     * @param id
     * @return Mono<Credit>
     */
    @GetMapping("/{id}")
    public Mono<Credit> getById(@PathVariable final String id) {
        return creditOperations.findById(id);
    }

    /**
     * Registra un producto de crédito.
     * @param credit
     * @return Mono<Credit>
     */
    @PostMapping
    public Mono<Credit> post(@RequestBody final Credit credit) {
        return creditOperations.create(credit);
    }

    /**
     * Actualiza un producto de crédito.
     * @param id
     * @param credit
     * @return Mono<Credit>
     */
    @PutMapping("/{id}")
    public Mono<Credit> put(@PathVariable final String id,
                            @RequestBody final Credit credit) {
        return creditOperations.update(id, credit);
    }

    /**
     * Elimina un producto de crédito.
     * @param id
     */
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable final String id) {
        creditOperations.delete(id);
    }
}
