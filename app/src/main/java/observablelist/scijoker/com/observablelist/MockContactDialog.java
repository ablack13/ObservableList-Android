package observablelist.scijoker.com.observablelist;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.scijoker.observablelist.ObservableList;

/**
 * Created by scijoker on 13.01.16.
 */
public class MockContactDialog {
    public static MaterialDialog.Builder showAddDialog(Activity activity, ObservableList list) {

        EditText etFName = new EditText(activity);
        etFName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etFName.setHint("Add First Name");
        EditText etLName = new EditText(activity);
        etLName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etLName.setHint("Add Last Name");
        LinearLayout llContainer = new LinearLayout(activity);
        llContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        llContainer.setOrientation(LinearLayout.VERTICAL);
        llContainer.addView(etFName);
        llContainer.addView(etLName);
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity)
                .title("Add contact")
                .positiveText("Ok")
                .negativeText("Cancel")
                .positiveColorRes(R.color.colorPrimary)
                .negativeColorRes(R.color.colorPrimary)
                .customView(llContainer, false)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                        if (list != null) {
                            String fNameStr = etFName.getText().toString();
                            String lNameStr = etLName.getText().toString();
                            list.add(new ContactItem(99, fNameStr, lNameStr, false));
                        }
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        super.onNegative(dialog);
                    }
                });
        builder.show();
        return builder;
    }

    public static MaterialDialog.Builder showEditDialog(Activity activity, ContactItem contactItem) {

        EditText etFName = new EditText(activity);
        etFName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etFName.setHint("Add First Name");
        etFName.setText(contactItem.getfName().get());
        EditText etLName = new EditText(activity);
        etLName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        etLName.setHint("Add Last Name");
        etLName.setText(contactItem.getlName().get());
        LinearLayout llContainer = new LinearLayout(activity);
        llContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        llContainer.setOrientation(LinearLayout.VERTICAL);
        llContainer.addView(etFName);
        llContainer.addView(etLName);
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity)
                .title("Edit contact")
                .positiveText("Ok")
                .negativeText("Cancel")
                .positiveColorRes(R.color.colorPrimary)
                .negativeColorRes(R.color.colorPrimary)
                .customView(llContainer, false)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                        String fNameStr = etFName.getText().toString();
                        String lNameStr = etLName.getText().toString();
                        contactItem.getfName().set(fNameStr);
                        contactItem.getlName().set(lNameStr);
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        super.onNegative(dialog);
                    }
                });
        builder.show();
        return builder;
    }
}
