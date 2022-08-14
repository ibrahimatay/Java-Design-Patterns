package com.ibrahimatay;

class Memento<T> {
    private final T state;
    public Memento(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }
}

class Originator<T> {
    private T state;
    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public Memento<T> Redo() {
        return new Memento<>(this.state);
    }

    public void Undo(Memento<T> memento) {
        this.state = memento.getState();
    }
}

class CareTaker<T> {
    private Memento<T> memento;
    public Memento<T> getMemento() {
        return memento;
    }

    public void setMemento(Memento<T> memento) {
        this.memento = memento;
    }
}

public class Main {
    public static void main(String[] args) {
        Originator<Integer> originator = new Originator<>();
        originator.setState(1);

        CareTaker<Integer> careTaker = new CareTaker<>();
        careTaker.setMemento(originator.Redo());

        System.out.println(originator.getState());

        originator.setState(2);
        System.out.println(originator.getState());

        originator.Undo(careTaker.getMemento());

        System.out.println(originator.getState());
    }
}