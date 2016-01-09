package com.scijoker.observablelist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {
    private List<OnChangeListener<T>> listeners = new ArrayList<>();

    public ObservableArrayList() {
        super();
    }

    public ObservableArrayList(int capacity) {
        super(capacity);
    }

    public ObservableArrayList(Collection<? extends T> c) {
        super(c);
    }

    @Override
    public boolean add(T newValue) {
        boolean result = super.add(newValue);
        for (OnChangeListener<T> listener : listeners) {
            listener.onChanged(EventType.ADD, Collections.singletonList(new Event<>(size() - 1, null, newValue)));
        }
        return result;
    }

    @Override
    public void add(int i, T newValue) {
        super.add(i, newValue);

        for (OnChangeListener<T> listener : listeners) {
            listener.onChanged(EventType.ADD, Collections.singletonList(new Event<>(i, null, newValue)));
        }
    }

    @Override
    public T set(int i, T newValue) {
        T oldValue = get(i);
        T result = super.set(i, newValue);
        for (OnChangeListener<T> listener : listeners) {
            listener.onChanged(EventType.UPDATE, Collections.singletonList(new Event<>(i, oldValue, newValue)));
        }
        return result;
    }

    @Override
    public T remove(int index) {
        T result = super.remove(index);
        for (OnChangeListener<T> listener : listeners) {
            listener.onChanged(EventType.REMOVE, Collections.singletonList(new Event<>(index, result, null)));
        }
        return result;
    }

    @Override
    public boolean remove(Object oldValue) {
        int index = indexOf(oldValue);
        boolean result = super.remove(oldValue);
        if (result) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.REMOVE, Collections.singletonList(new Event<>(index, (T) oldValue, null)));
            }
        }
        return result;
    }

    @Override
    public void clear() {
        List<Event<T>> events = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            events.add(new Event<>(i, get(i), null));
        }
        if (!events.isEmpty()) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.REMOVE, events);
            }
        }
        super.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int startIndex = size();
        boolean result = super.addAll(c);
        List<Event<T>> events = new ArrayList<>();
        for (int i = startIndex; i < size(); i++) {
            events.add(new Event<>(i, null, get(i)));
        }
        if (!events.isEmpty()) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.ADD, events);
            }
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean result = super.addAll(index, c);
        List<Event<T>> events = new ArrayList<>();
        for (int i = index; i < size(); i++) {
            events.add(new Event<>(i, null, get(i)));
        }
        if (!events.isEmpty()) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.ADD, events);
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        List<Event<T>> events = new ArrayList<>();
        for (int i = size() - 1; i >= 0; i--) {
            if (contains(get(i))) events.add(new Event<>(i, get(i), null));
        }
        boolean result = super.removeAll(c);
        if (result) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.REMOVE, events);
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        List<Event<T>> events = new ArrayList<>();
        for (int i = size() - 1; i >= 0; i--) {
            if (!contains(get(i))) events.add(new Event<>(i, get(i), null));
        }
        boolean result = super.retainAll(c);
        if (result) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChanged(EventType.REMOVE, events);
            }
        }
        return result;
    }

    @Override
    public void addOnChangeListener(OnChangeListener<T> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSubscriber(OnChangeListener<T> listener) {
        listeners.remove(listener);
    }
}
