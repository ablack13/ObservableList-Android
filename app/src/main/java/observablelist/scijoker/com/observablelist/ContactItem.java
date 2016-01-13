package observablelist.scijoker.com.observablelist;

import com.scijoker.observablelist.type.BooleanProperty;
import com.scijoker.observablelist.type.IntegerProperty;
import com.scijoker.observablelist.ObserveObject;
import com.scijoker.observablelist.type.StringProperty;

/**
 * Created by scijoker on 12.01.16.
 */
public class ContactItem extends ObserveObject {
    private IntegerProperty id;
    private StringProperty fName;
    private StringProperty lName;
    private BooleanProperty isChecked;

    public ContactItem(int id, String fName, String lName, boolean isChecked) {
        this.id = new IntegerProperty(this, id);
        this.fName = new StringProperty(this, fName);
        this.lName = new StringProperty(this, lName);
        this.isChecked = new BooleanProperty(this, isChecked);
    }

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getfName() {
        return fName;
    }

    public StringProperty getlName() {
        return lName;
    }

    public BooleanProperty getIsChecked() {
        return isChecked;
    }
}
