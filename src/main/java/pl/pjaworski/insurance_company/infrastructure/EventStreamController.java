package pl.pjaworski.insurance_company.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pjaworski.insurance_company.eventstream.DomainEvent;
import pl.pjaworski.insurance_company.eventstream.EventStream;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EventStreamController {
    private final EventStream eventStream;

    @GetMapping("event-stream/{aggregateId}")
    private List<DomainEvent> findByAggregateId(@PathVariable UUID aggregateId) {
        return eventStream.findAllById(aggregateId);
    }
}
