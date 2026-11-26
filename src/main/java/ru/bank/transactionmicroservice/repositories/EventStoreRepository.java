package ru.bank.transactionmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bank.transactionmicroservice.entities.Event;

import java.util.UUID;

@Repository
public interface EventStoreRepository extends JpaRepository<Event, UUID> {
}
