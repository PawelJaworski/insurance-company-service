package pl.pjaworski.insurance_company.infrastructure;

import java.util.Optional;

public interface DomainEventRepository {
    DomainEventEntity save(DomainEventEntity entity);
    Optional<DomainEventEntity> findById(Long id);
    void deleteAll();
}
