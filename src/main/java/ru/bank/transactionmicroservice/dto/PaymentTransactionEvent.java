package ru.bank.transactionmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bank.transactionmicroservice.services.TransactionalService;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionEvent {

    private UUID fromCardId;

    private UUID toCardId;

    private BigDecimal amount;

    private TransferType type;

    private UUID transferId;

    private UUID idempotencyKey;

    public enum TransferType { DEBIT, CREDIT }
}
