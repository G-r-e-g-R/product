package com.nttdata.product.infraestructure.model.dao;

import com.nttdata.product.domain.CreditType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
/**
 * ACREDITDAO: Contiene los atributos del documento Credito (Credit) para la persistencia
 */
@Data
@Document("credit")
public class CreditDao {
    @Id
    private String id;
    private CreditType creditType;          // Tipo de Credito: Personal, Empresarial, etc
    private int maximumNumberCredit;        // Numero maximo de creditos 0: Sin limites.
    private String cardNumber;              // Numero de Tarjeta de credito

}
