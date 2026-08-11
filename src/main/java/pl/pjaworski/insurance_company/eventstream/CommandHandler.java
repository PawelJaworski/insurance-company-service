package pl.pjaworski.insurance_company.eventstream;

public interface CommandHandler<T> {
    Long handle(T cmd);
}
