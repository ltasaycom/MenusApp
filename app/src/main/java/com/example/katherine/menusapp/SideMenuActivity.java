package com.example.katherine.menusapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;

import java.util.ArrayList;

import yalantis.com.sidemenu.interfaces.Resourceble;

public class SideMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);

        /*ViewAnimator viewAnimator = new ViewAnimator<>(SideMenuActivity.this,
                new ArrayList<Resourceble>(),
                (LinearLayout) findViewById(R.id.left_drawer),
                contentFragment, drawerLayout);
        //to open menu you have to override ActionBarDrawerToggle method
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            super.onDrawerSlide(drawerView, slideOffset);
            if (slideOffset > 0.6 && viewAnimator.getLinearLayout().getChildCount() == 0)
                viewAnimator.showMenuContent();
        }
        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            viewAnimator.getLinearLayout().removeAllViews();
            viewAnimator.getLinearLayout().invalidate();
        }*/

    }
}
