package LLD.ObserverPattern;

// The subject interface provides methods for managing observers: registering, removing, and notifying them.

interface FitnessDataSubject {
    void registerObserver(FitnessDataObserver observer);
    void removeObserver(FitnessDataObserver observer);
    void notifyObservers();
}
