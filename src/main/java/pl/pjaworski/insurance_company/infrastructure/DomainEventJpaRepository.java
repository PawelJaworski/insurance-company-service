package pl.pjaworski.insurance_company.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainEventJpaRepository extends DomainEventRepository, JpaRepository<DomainEventEntity, Long> {
}
