package LLD.ObserverPattern;

// Each observer receives a reference to the subject and can pull whatever data it needs. This keeps the interface stable even as FitnessData gains new fields.

interface FitnessDataObserver {
    void update(FitnessData data);
}
