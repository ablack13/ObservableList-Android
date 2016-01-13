package com.scijoker.observablelist.type;

import com.scijoker.observablelist.ObserveObject;

/**
 * Created by scijoker on 13.01.16.
 */
public class IntegerProperty extends ObjectProperty<Integer> {

    public <T extends ObserveObject> IntegerProperty(T t, Integer defValue) {
        super(t, defValue);
    }
}
