package pl.pjaworski.insurance_company.eventstream;

import java.util.UUID;

public interface CommandHandler<T> {
    UUID handle(T cmd);
}
