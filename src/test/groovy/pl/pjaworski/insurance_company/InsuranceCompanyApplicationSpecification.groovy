package pl.pjaworski.insurance_company

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent
import pl.pjaworski.insurance_company.infrastructure.DomainEventEntity
import pl.pjaworski.insurance_company.infrastructure.DomainEventRepository
import spock.lang.Specification

@SpringBootTest
class InsuranceCompanyApplicationSpecification extends Specification {

    @Autowired
    DomainEventRepository domainEventRepository

    def "loads spring context"() {
        expect:
        true
    }

    def "test repository"() {
        given:
        def policyIssuedEvent = new PolicyIssuedEvent(UUID.randomUUID(), "Pawel", "Jaworski", "FIRE")

        when:
        domainEventRepository.save(new DomainEventEntity(policyIssuedEvent))

        then:
        domainEventRepository.findAll().collect { it.toDomainEvent() } == [policyIssuedEvent]
    }
}
