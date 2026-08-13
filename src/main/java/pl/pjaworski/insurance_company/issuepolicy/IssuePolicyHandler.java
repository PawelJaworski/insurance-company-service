package pl.pjaworski.insurance_company.issuepolicy;

import pl.pjaworski.insurance_company.eventstream.CommandHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class IssuePolicyHandler implements CommandHandler<IssuePolicyCmd> {
    @Override
    public Long handle(IssuePolicyCmd command) {
        return null;
    }
}
