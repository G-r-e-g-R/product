package com.nttdata.product.infraestructure.model.dao;

import com.nttdata.product.domain.AccountType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
/**
 * ACCOUNTDAO: Contiene los atributos del documento Cuenta (Account) para la persistencia
 */
@Data
@Document("account")
public class AccountDao {
    @Id
    private String id;
    private AccountType accountType;            // Tipo de Cuenta: Ahorro, cuenta corriente, Plazo Fijo
    private String name;                        // Nombre de la cuenta (Ej. Cuenta Sueldo, etc. Opcional)
    private Double commission;                  // Comisión de la cuenta
    private int limitMovement;                  // Limite Máximo de movimiento
    private Double minimumDailyAverageAmount;   // Monto mínimo de promedio diario
}
