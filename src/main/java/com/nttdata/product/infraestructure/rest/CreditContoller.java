package com.nttdata.product.infraestructure.rest;

import com.nttdata.product.application.AccountOperations;
import com.nttdata.product.application.CreditOperations;
import com.nttdata.product.domain.Account;
import com.nttdata.product.domain.Credit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * CREDITCONTROLLER: Publica las operaciones de los creditos (Credit)
 */
@Slf4j
@RestController
@RequestMapping("/products/credit")
@RequiredArgsConstructor
public class CreditContoller {
    private final CreditOperations creditOperations;

    @GetMapping
    public Flux<Credit> getAll(){
        return creditOperations.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Credit> getById(@PathVariable String id){
        return creditOperations.findById(id);
    }
    @PostMapping
    public Mono<Credit> post(@RequestBody Credit credit){
        return creditOperations.create(credit);
    }
    @PutMapping("/{id}")
    public Mono<Credit> put(@PathVariable String id, @RequestBody Credit credit){
        return creditOperations.update(id, credit);
    }
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable String id){
        creditOperations.delete(id);
    }
}
