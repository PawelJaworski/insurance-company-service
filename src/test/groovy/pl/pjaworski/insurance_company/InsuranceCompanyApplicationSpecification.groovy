package pl.pjaworski.insurance_company

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.pjaworski.insurance_company.domain.events.PolicyIssuedEvent
import pl.pjaworski.insurance_company.eventstream.EventStream
import pl.pjaworski.insurance_company.infrastructure.DomainEventEntity
import pl.pjaworski.insurance_company.infrastructure.DomainEventRepository
import spock.lang.Specification

@SpringBootTest
class InsuranceCompanyApplicationSpecification extends Specification {

    @Autowired
    EventStream eventStream

    def "loads spring context"() {
        expect:
        true
    }

    def "test repository"() {
        given:
        def aggregateId = UUID.randomUUID()
        def policyIssuedEvent = new PolicyIssuedEvent(aggregateId, "Pawel", "Jaworski", "FIRE")

        when:
        eventStream.append([policyIssuedEvent])

        then:
        eventStream.findAllById(aggregateId) == [policyIssuedEvent]
    }
}
