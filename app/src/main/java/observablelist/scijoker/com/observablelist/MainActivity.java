package observablelist.scijoker.com.observablelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.scijoker.observablelist.ObservableList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ContactsRecyclerListAdapter adapter;
    private ObservableList<ContactItem> contactItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListeners();
    }

    private void initUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initToolbar();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactItems = MockContactsListDataHelper.getContactsList();
        contactItems.addOnChangeListener((eventType, events) -> {
            for (ObservableList.Event<ContactItem> event : events) {
                switch (eventType) {
                    case ADD: {
                        adapter.notifyItemInserted(event.getIndex());
                        break;
                    }
                    case REMOVE: {
                        adapter.notifyItemRemoved(event.getIndex());
                        break;
                    }
                    case UPDATE: {
                        adapter.notifyItemChanged(event.getIndex());
                        break;
                    }
                    case UPDATE_IN_OBJECT: {
                        int obj = contactItems.indexOf(event.getNewValue());
                        adapter.notifyItemChanged(obj);
                        break;
                    }
                }
            }
        });

        adapter = new ContactsRecyclerListAdapter(getActivity(), contactItems);
        adapter.setOnItemClickListener(new ContactsRecyclerListAdapter.OnItemClickListener() {
            @Override
            public void onClick(ContactItem contactItem) {
                MockContactDialog.showEditDialog(getActivity(), contactItem);
            }

            @Override
            public void onLongClick(ContactItem contactItem) {
                contactItems.remove(contactItem);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_contacts_white_24dp);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_action_add_contact) {
                MockContactDialog.showAddDialog(getActivity(), contactItems);
            }
            return true;
        });
    }

    private void initListeners() {
    }

    private AppCompatActivity getActivity() {
        return MainActivity.this;
    }
}
