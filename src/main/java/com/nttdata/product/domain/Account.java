package com.nttdata.product.domain;

import lombok.Data;
/**
 * ACCOUNT: La clase contendrá  información de las cuentas Bancarias (AHORRO, CUENTA CORRIENTE y PLAZO FIJO)
 */
@Data
public class Account {

    private String id;
    private AccountType accountType;            // Tipo de Cuenta: Ahorro, cuenta corriente, Plazo Fijo
    private String name;                        // Nombre de la cuenta (Ej. Cuenta Sueldo, etc. Opcional)
    private Double commission;                  // Comisión de la cuenta
    private int limitMovement;                  // Limite Máximo de movimiento
    private Double minimumDailyAverageAmount;   // Monto mínimo de promedio diario


}
