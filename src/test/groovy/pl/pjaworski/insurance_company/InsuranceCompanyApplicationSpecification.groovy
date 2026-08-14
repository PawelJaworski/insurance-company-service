package pl.pjaworski.insurance_company

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import pl.pjaworski.insurance_company.eventstream.EventStream
import spock.lang.Specification

@SpringBootTest
class InsuranceCompanyApplicationSpecification extends Specification {

    @Autowired
    EventStream eventStream

    def "loads spring context"() {
        expect:
        true
    }
}
