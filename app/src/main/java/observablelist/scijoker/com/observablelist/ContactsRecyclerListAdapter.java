package observablelist.scijoker.com.observablelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scijoker.observablelist.ObservableList;

/**
 * Created by scijoker on 12.01.16.
 */
public class ContactsRecyclerListAdapter extends RecyclerView.Adapter<ContactsRecyclerListAdapter.VHolder> {
    private Context context;
    private ObservableList<ContactItem> contacts;
    private OnItemClickListener clickListener;

    public ContactsRecyclerListAdapter(Context context, ObservableList<ContactItem> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    class VHolder extends RecyclerView.ViewHolder {
        private CheckBox cbStatus;
        private TextView tvFName;
        private TextView tvLName;
        private LinearLayout llContainer;

        public VHolder(View itemView) {
            super(itemView);
            cbStatus = (CheckBox) itemView.findViewById(R.id.cb_status);
            tvFName = (TextView) itemView.findViewById(R.id.tv_fName);
            tvLName = (TextView) itemView.findViewById(R.id.tv_lName);
            llContainer = (LinearLayout) itemView.findViewById(R.id.ll_container);
        }
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHolder(LayoutInflater.from(context).inflate(R.layout.list_item_contact, null));
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        final ContactItem contact = contacts.get(position);
        if (contact != null) {
            holder.cbStatus.setChecked(contact.getIsChecked().get());
            holder.tvFName.setText(contact.getfName().get());
            holder.tvLName.setText(contact.getlName().get());
            holder.cbStatus.setOnClickListener(v -> contact.getIsChecked().set(((CheckBox) v).isChecked()));
            holder.llContainer.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onClick(contact);
                }
            });
            holder.llContainer.setOnLongClickListener(v -> {
                clickListener.onLongClick(contact);
                return true;
            });
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(true);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface OnItemClickListener {
        void onClick(ContactItem contactItem);

        void onLongClick(ContactItem contactItem);
    }
}
