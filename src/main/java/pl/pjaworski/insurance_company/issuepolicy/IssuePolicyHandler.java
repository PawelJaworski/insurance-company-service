package pl.pjaworski.insurance_company.issuepolicy;

import pl.pjaworski.insurance_company.eventstream.CommandHandler;

public class IssuePolicyHandler implements CommandHandler<IssuePolicyCmd> {
    @Override
    public Long handle(IssuePolicyCmd command) {
        return null;
    }
}
