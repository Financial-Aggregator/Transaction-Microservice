package ru.bank.transactionmicroservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.bank.transactionmicroservice.dto.PaymentTransactionEvent;
import ru.bank.transactionmicroservice.services.TransactionalService;

@Component
@RequiredArgsConstructor
public class TransactionEventConsumer {

    private final TransactionalService transactionalService;

    @KafkaListener(topics = "transfer-events")
    public void createRecordInDatabase(
            @Payload PaymentTransactionEvent event,
            @Header(KafkaHeaders.RECEIVED_KEY) String messageKey
    ) {

        transactionalService.processTransfer();
    }
}
