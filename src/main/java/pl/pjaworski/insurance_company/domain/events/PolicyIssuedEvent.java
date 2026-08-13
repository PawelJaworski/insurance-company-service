package pl.pjaworski.insurance_company.domain.events;

import pl.pjaworski.insurance_company.eventstream.DomainEvent;

import java.util.UUID;

public record PolicyIssuedEvent(
        UUID aggregateId,
        String policyHolderName,
        String policyHolderSurname,
        String coverage
) implements DomainEvent {
    @Override
    public DomainEventType eventType() {
        return DomainEventType.POLICY_ISSUED;
    }
}
