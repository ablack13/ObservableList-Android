package com.scijoker.observablelist;

import com.scijoker.observablelist.type.ObjectProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scijoker on 13.01.16.
 */
public abstract class ObserveObject<T> implements ObjectProperty.Callbacks {
    private ObservableList<T> list;
    private boolean isIgnore;

    @Override
    public void onChanged() {
        if (list != null && list.getListeners() != null) {
            for (ObservableList.OnChangeListener<T> onChangeListener : list.getListeners()) {
                List<ObservableList.Event<T>> eventList = new ArrayList<>();
                eventList.add(new ObservableList.Event<T>(ObservableList.Event.NONE, null, (T) getObserveObject()));
                onChangeListener.onChanged(ObservableList.EventType.UPDATE_IN_OBJECT, eventList);
            }
        }
    }

    public void setList(ObservableList<T> list) {
        this.list = list;
    }

    public Object getObserveObject() {
        return this;
    }
}
