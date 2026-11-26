package ru.bank.transactionmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_store")
public class Event {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "from_card_id", nullable = false)
    private UUID fromCardId;

    @Column(name = "to_card_id", nullable = false)
    private UUID toCardId;

    @Column(name = "amount", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private TransferType type;

    @PrePersist
    void initializeDefaults() {
        if (id == null) id = UUID.randomUUID();
    }

    public enum TransferType { DEBIT, CREDIT }

}
