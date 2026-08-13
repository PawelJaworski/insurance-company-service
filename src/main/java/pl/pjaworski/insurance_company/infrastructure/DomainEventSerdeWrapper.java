package pl.pjaworski.insurance_company.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import pl.pjaworski.insurance_company.domain.events.DomainEventType;
import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent;
import pl.pjaworski.insurance_company.eventstream.DomainEvent;

import static pl.pjaworski.insurance_company.domain.events.DomainEventType.POLICY_ISSUED;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PolicyIssuedSerdeWrapper.class, name = "POLICY_ISSUED"),
})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface DomainEventSerdeWrapper {
    DomainEventType getEventType();
    DomainEvent event();
}
