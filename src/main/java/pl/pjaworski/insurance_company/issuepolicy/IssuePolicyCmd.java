package pl.pjaworski.insurance_company.issuepolicy;

public record IssuePolicyCmd(
        String policyHolderName,
        String policyHolderSurname,
        String coverage
) {
}
