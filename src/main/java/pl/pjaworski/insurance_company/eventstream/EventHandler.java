package pl.pjaworski.insurance_company.eventstream;

public interface EventHandler<E> {
    void handle(E event);
}
