package pl.pjaworski.insurance_company.eventstream;

import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent;

import java.util.Collection;

public interface StateProjector<S> {
    default S hydrate(S state, Collection<DomainEvent> events) {
        return events.stream().reduce(state, this::apply, (_, s2) -> s2);
    }

    private S apply(S state, DomainEvent event) {
        return switch (event.eventType()) {
            case POLICY_ISSUED -> apply(state, (PolicyIssuedEvent) event);
        };
    }

    default S apply(S state, PolicyIssuedEvent event) {
        return state;
    }
}
