package com.scijoker.observablelist;

import java.util.List;

public interface ObservableList<T> extends List<T> {
    void addOnChangeListener(OnChangeListener<T> listener);

    void removeSubscriber(OnChangeListener<T> listener);

    public interface OnChangeListener<T> {
        void onChanged(EventType eventType, List<Event<T>> events);
    }

    public enum EventType {
        ADD, REMOVE, UPDATE
    }

    public static class Event<T> {
        private int index;
        private T oldValue;
        private T newValue;

        public Event(int index, T oldValue, T newValue) {
            this.index = index;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public int getIndex() {
            return index;
        }

        public T getOldValue() {
            return oldValue;
        }

        public T getNewValue() {
            return newValue;
        }
    }
}


