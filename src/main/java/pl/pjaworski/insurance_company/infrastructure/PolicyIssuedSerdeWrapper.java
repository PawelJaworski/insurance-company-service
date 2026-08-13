package pl.pjaworski.insurance_company.infrastructure;

import pl.pjaworski.insurance_company.domain.events.DomainEventType;
import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent;

public record PolicyIssuedSerdeWrapper(PolicyIssuedEvent event) implements  DomainEventSerdeWrapper {
    @Override
    public DomainEventType getEventType() {
        return DomainEventType.POLICY_ISSUED;
    }
}
