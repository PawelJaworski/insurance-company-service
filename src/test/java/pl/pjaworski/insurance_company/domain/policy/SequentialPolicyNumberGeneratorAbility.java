package pl.pjaworski.insurance_company.domain.policy;

public interface SequentialPolicyNumberGeneratorAbility {
    PolicyNumberGenerator INSTANCE = new SequentialPolicyNumberGenerator();

    default PolicyNumberGenerator getPolicyNumberGenerator() {
        return INSTANCE;
    }
}
