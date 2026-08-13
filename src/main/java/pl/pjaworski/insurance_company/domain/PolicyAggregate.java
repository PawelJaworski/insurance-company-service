package pl.pjaworski.insurance_company.domain;

import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent;
import pl.pjaworski.insurance_company.eventstream.StateProjector;

import java.util.UUID;

public record PolicyAggregate(UUID id) implements StateProjector<PolicyAggregate> {
    @Override
    public PolicyAggregate apply(PolicyAggregate state, PolicyIssuedEvent event) {
        return new PolicyAggregate(event.aggregateId());
    }
}
