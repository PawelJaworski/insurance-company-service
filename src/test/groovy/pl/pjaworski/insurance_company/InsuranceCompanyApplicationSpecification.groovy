package pl.pjaworski.insurance_company

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class InsuranceCompanyApplicationSpecification extends Specification {

    def "loads spring context"() {
        expect:
        true
    }
}
