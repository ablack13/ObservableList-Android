package observablelist.scijoker.com.observablelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.scijoker.observablelist.ObservableArrayList;
import com.scijoker.observablelist.ObservableList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ObservableList<Integer> list = new ObservableArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        list.addOnChangeListener(new ObservableList.OnChangeListener<Integer>() {
            @Override
            public void onChanged(ObservableList.EventType eventType, List<ObservableList.Event<Integer>> events) {
                if (listView.getAdapter() != null) {
                    for (int i = 0; i < events.size(); i++) {
                        ObservableList.Event<Integer> event = events.get(i);
                        Toast.makeText(MainActivity.this, "event type: "+eventType.name().toString()+" old value:" + event.getOldValue() + " new value:" + event.getNewValue() + " [" + event.getIndex() + "]", Toast.LENGTH_LONG).show();
                    }
                    ((ArrayAdapter) listView.getAdapter()).notifyDataSetChanged();
                }
            }
        });

        listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    list.add(0, 433);
                } else if (i == 1) {
                    list.remove(i);
                } else {
                    list.set(i, (list.get(i).intValue() + 1));
                }
            }
        });
        listView.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list));
    }
}
