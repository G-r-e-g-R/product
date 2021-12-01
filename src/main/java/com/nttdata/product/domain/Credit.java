package com.nttdata.product.domain;

import lombok.Data;
/**
 * CREDIT: La clase contendrá  información de los Creditos (PERSONAL, EMPRESARIAL y TARJETAS DE CREDITO)
 */
@Data
public class Credit {

    private String id;
    private CreditType creditType;          // Tipo de Credito: Personal, Empresarial, etc
    private int maximumNumberCredit;        // Numero maximo de creditos 0: Sin limites.
    private String cardNumber;              // Numero de Tarjeta de credito

}
