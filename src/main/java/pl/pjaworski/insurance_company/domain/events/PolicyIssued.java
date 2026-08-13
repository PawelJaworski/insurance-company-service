package pl.pjaworski.insurance_company.domain.events;

import pl.pjaworski.insurance_company.eventstream.DomainEvent;

public record PolicyIssued(Long policyId, DomainEventType eventType) implements DomainEvent {
}
