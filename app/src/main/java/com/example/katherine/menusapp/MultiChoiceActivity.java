package com.example.katherine.menusapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MultiChoiceActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_choice);

        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice);
        adapter.add("Nota 1");
        adapter.add("Nota 2");
        adapter.add("Nota 3");
        adapter.add("Nota 4");
        adapter.add("Nota 5");
        listView.setAdapter(adapter);

        // Mode Action Contextual
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                mode.getMenuInflater().inflate(R.menu.action, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to an invalidate() request
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Reading selected items
                List<String> notes = new ArrayList<String>();
                int len = listView.getCount();
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                for (int i = 0; i < len; i++){
                    if (checked.get(i)) {
                        notes.add(String.valueOf(listView.getAdapter().getItem(i)));
                    }
                }

                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.action_save:
                        Toast.makeText(MultiChoiceActivity.this, "Guardando la notas " + TextUtils.join(", ", notes) + "...", Toast.LENGTH_SHORT).show();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    case R.id.action_share:
                        Toast.makeText(MultiChoiceActivity.this, "Compartiendo la nota " + TextUtils.join(", ", notes) + "...", Toast.LENGTH_SHORT).show();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    case R.id.action_delete:
                        Toast.makeText(MultiChoiceActivity.this, "Eliminando la nota " + TextUtils.join(", ", notes) + "...", Toast.LENGTH_SHORT).show();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }


        });
    }
}
