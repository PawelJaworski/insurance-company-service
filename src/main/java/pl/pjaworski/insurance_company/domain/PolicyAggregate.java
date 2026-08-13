package pl.pjaworski.insurance_company.domain;

import pl.pjaworski.insurance_company.domain.events.PolicyIssued;
import pl.pjaworski.insurance_company.eventstream.StateProjector;

public record PolicyAggregate(Long id) implements StateProjector<PolicyAggregate> {
    @Override
    public PolicyAggregate apply(PolicyAggregate state, PolicyIssued event) {
        return new PolicyAggregate(event.policyId());
    }
}
