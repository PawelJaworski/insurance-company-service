package pl.pjaworski.insurance_company.eventstream;

import pl.pjaworski.insurance_company.domain.events.DomainEventType;

public interface DomainEvent {
    DomainEventType eventType();
}
