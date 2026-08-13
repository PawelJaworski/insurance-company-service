package pl.pjaworski.insurance_company.eventstream;

import pl.pjaworski.insurance_company.domain.events.DomainEventType;

import java.util.UUID;

public interface DomainEvent {
    UUID aggregateId();
    DomainEventType eventType();
}
