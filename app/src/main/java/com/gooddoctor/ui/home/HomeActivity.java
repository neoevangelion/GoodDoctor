package com.gooddoctor.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.gooddoctor.R;
import com.gooddoctor.widget.SearchBar;

public class HomeActivity extends FragmentActivity {

    private Fragment homeFragment;
    private Fragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager = getSupportFragmentManager();
        homeFragment = fragmentManager.findFragmentById(R.id.home_home_fragment);
        searchFragment = fragmentManager.findFragmentById(R.id.home_search_fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(searchFragment);
        transaction.show(homeFragment);
        transaction.commit();

        final SearchBar searchBar = (SearchBar)findViewById(R.id.home_search_bar);
        searchBar.setInterceptMode(true);
        searchBar.setSearchButtonVisibility(false);
        searchBar.setOnInterceptClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBar.setInterceptMode(false);
                searchBar.setSearchButtonVisibility(true);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show(searchFragment);
                transaction.hide(homeFragment);
                transaction.commit();
            }
        });
    }
}
