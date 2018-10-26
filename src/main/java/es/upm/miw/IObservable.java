package es.upm.miw;

public interface IObservable {
    void addObserver(IObserver IObserver);

    void removeObserver(IObserver IObserver);
}
