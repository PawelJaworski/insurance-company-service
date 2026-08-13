package pl.pjaworski.insurance_company.infrastructure;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pl.pjaworski.insurance_company.domain.events.DomainEventType;
import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent;
import pl.pjaworski.insurance_company.eventstream.DomainEvent;

@Entity
@Table(name = "domain_event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DomainEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Enumerated(EnumType.STRING)
    private DomainEventType type;

    @NonNull
    @JdbcTypeCode(SqlTypes.JSON)
    private DomainEventSerdeWrapper eventJson;

    public DomainEventEntity(DomainEvent event) {
        this.type = event.eventType();
        this.eventJson = switch (event) {
            case PolicyIssuedEvent e -> new PolicyIssuedSerdeWrapper(e);
            default -> throw new IllegalStateException("Unexpected value: " + event);
        };
    }

    public DomainEvent toDomainEvent() {
        return eventJson.event();
    }
}
