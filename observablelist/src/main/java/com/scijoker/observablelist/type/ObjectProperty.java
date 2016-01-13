package com.scijoker.observablelist.type;

/**
 * Created by scijoker on 13.01.16.
 */
public abstract class ObjectProperty<T> {
    protected T value;
    protected Callbacks callback;

    public ObjectProperty(Callbacks callback, T defValue) {
        this.callback = callback;
        this.value = defValue;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        set(value, false);
    }

    public void set(T value, boolean isIgnore) {
        if (!value.equals(this.value)) {
            this.value = value;
            if (!isIgnore && callback != null) {
                callback.onChanged();
            }
        }
    }

    public static interface Callbacks<T> {
        public void onChanged();
    }
}
