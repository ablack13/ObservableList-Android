package com.scijoker.observablelist;

import java.util.List;

public interface ObservableList<T> extends List<T> {
    void addOnChangeListener(OnChangeListener<T> listener);

    void removeSubscriber(OnChangeListener<T> listener);

    public interface OnChangeListener<T> {
        void onChanged(EventType eventType, List<Event<T>> events);
    }

    List<OnChangeListener<T>> getListeners();

    public enum EventType {
        ADD, REMOVE, UPDATE, UPDATE_IN_OBJECT
    }

    public static class Event<T> {
        public static int NONE = -1;
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


