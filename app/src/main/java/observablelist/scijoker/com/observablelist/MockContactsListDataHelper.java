package observablelist.scijoker.com.observablelist;

import com.scijoker.observablelist.ObservableArrayList;
import com.scijoker.observablelist.ObservableList;

/**
 * Created by scijoker on 12.01.16.
 */
public class MockContactsListDataHelper {
    public static ObservableList<ContactItem> getContactsList() {
        ObservableList<ContactItem> contacts = new ObservableArrayList<>();
        contacts.add(new ContactItem(1, "John", "Smith", false));
        contacts.add(new ContactItem(2, "Ozzy", "Osbourne", false));
        contacts.add(new ContactItem(3, "Jonas", "Jordison", false));
        contacts.add(new ContactItem(4, "Charlie", "Manson", false));
        contacts.add(new ContactItem(5, "Jason", "Statham", false));
        contacts.add(new ContactItem(6, "Alicia", "Vikander", false));
        contacts.add(new ContactItem(7, "Kelly", "Osbourne", false));
        contacts.add(new ContactItem(8, "Emma", "Roberts", false));
        contacts.add(new ContactItem(9, "David", "Bowie", false));
        contacts.add(new ContactItem(10, "Amy", "Poehler", false));
        contacts.add(new ContactItem(11, "Jim", "Parsons", false));
        contacts.add(new ContactItem(12, "Sharon", "Osbourne", false));
        contacts.add(new ContactItem(13, "Dwayne", "Johnson", false));
        contacts.add(new ContactItem(14, "Eva", "Green", false));
        contacts.add(new ContactItem(15, "Christian", "Bale", false));
        contacts.add(new ContactItem(16, "Kirsten", "Dunst", false));
        contacts.add(new ContactItem(17, "Joe", "Jonas", false));
        contacts.add(new ContactItem(18, "Hailey", "Baldwin", false));
        return contacts;
    }
}
