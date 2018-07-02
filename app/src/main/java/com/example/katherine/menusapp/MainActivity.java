package com.example.katherine.menusapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardview = (CardView)findViewById(R.id.cardview);
        //registerForContextMenu(cardview);

        cardview.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });


    }

    private ActionMode mActionMode = null;


    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            mode.getMenuInflater().inflate(R.menu.action, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_save:

                    Toast.makeText(MainActivity.this, "Guardando la nota...", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.action_share:

                    Toast.makeText(MainActivity.this, "Compartiendo la nota...", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.action_delete:

                    Toast.makeText(MainActivity.this, "Eliminando la nota...", Toast.LENGTH_SHORT).show();
                     // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_favority:
                Toast.makeText(MainActivity.this, "La nota ha sido guardada...favority", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_share:
                Toast.makeText(MainActivity.this, "La nota ha sido compartida...share", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_home:
                Toast.makeText(this, "Regresando al inicio...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_takepicture:
                Toast.makeText(this, "Tomando una foto...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_day_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista diaria activada...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_week_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista semanal activada...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_month_view:
                item.setChecked(true);
                Toast.makeText(this, "Vista mensual activada...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_toggle:
                if(item.isChecked()){
                    item.setChecked(false);
                    Toast.makeText(this, "Modo offline desactivado...", Toast.LENGTH_SHORT).show();
                }else{
                    item.setChecked(true);
                    Toast.makeText(this, "Modo offline activado...", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_about:
                Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_favority:
                        Toast.makeText(MainActivity.this, "La nota ha sido guardada...favority", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_share:
                        Toast.makeText(MainActivity.this, "La nota ha sido compartida...share", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        // Show the menu
        popup.show();
    }

    public void callMultiChoice(View view)
    {
        intent = new Intent(MainActivity.this,MultiChoiceActivity.class);
        startActivity(intent);
    }

    public void callDashboard(View view)
    {
        intent = new Intent(MainActivity.this,DashboardActivity.class);
        startActivity(intent);
    }

    public void callHome(View view)
    {
        intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}
