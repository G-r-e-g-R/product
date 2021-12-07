package com.nttdata.product.infraestructure.model.dao;

import com.nttdata.product.domain.AccountType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
/**
 * ACCOUNTDAO.
 * Contiene los atributos del documento Cuenta (Account) para la persistencia
 */
@Data
@Document("account")
public class AccountDao {
    /**
     * Codigo del producto cuenta bancaria.
     */
    @Id
    private String id;
    /**
     * Tipo de Cuenta: Ahorro, cuenta corriente, Plazo Fijo.
     */
    private AccountType accountType;
    /**
     * Nombre de la cuenta (Ej. Cuenta Sueldo, etc. Opcional).
     */
    private String name;
    /**
     * Comisión de la cuenta.
     */
    private Double commission;
    /**
     * Limite Máximo de movimiento.
     */
    private int limitMovement;
    /**
     * Monto mínimo de promedio diario.
     */
    private Double minimumDailyAverageAmount;
}
