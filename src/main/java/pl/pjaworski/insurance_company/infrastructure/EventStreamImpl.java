package pl.pjaworski.insurance_company.infrastructure;

import org.springframework.stereotype.Component;
import pl.pjaworski.insurance_company.eventstream.DomainEvent;
import pl.pjaworski.insurance_company.eventstream.EventStream;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component
public class EventStreamImpl implements EventStream {

    private final DomainEventRepository repository;

    public EventStreamImpl(DomainEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void append(Collection<DomainEvent> events) {
        events.forEach(event -> repository.save(new DomainEventEntity(event)));
    }

    @Override
    public List<DomainEvent> findAllById(UUID id) {
        return repository.findAllByAggregateId(id).stream()
                .map(DomainEventEntity::toDomainEvent)
                .toList();
    }
}
