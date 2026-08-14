package pl.pjaworski.insurance_company.infrastructure;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pl.pjaworski.insurance_company.domain.events.DomainEventType;
import pl.pjaworski.insurance_company.eventstream.DomainEvent;

import java.util.UUID;

/**
 * serialization:
 * this.eventJson = switch (event.eventType()) {
 *     case FOO -> new FooEventSerdeWrapper(e);
 *     case BAR -> new BarEventSerdeWrapper(e);
 * };
 */
@Entity
@Table(name = "domain_event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DomainEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    private UUID aggregateId;

    @Enumerated(EnumType.STRING)
    private DomainEventType type;

    @NonNull
    @JdbcTypeCode(SqlTypes.JSON)
    private DomainEventSerdeWrapper eventJson;

    public DomainEventEntity(DomainEvent event) {
        this.aggregateId = event.aggregateId();
        this.type = event.eventType();
    }

    public DomainEvent toDomainEvent() {
        return eventJson.event();
    }
}
