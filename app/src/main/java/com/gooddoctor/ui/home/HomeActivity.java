package com.gooddoctor.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.gooddoctor.R;
import com.gooddoctor.ui.widget.SearchBar;

public class HomeActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final SearchBar searchBar = (SearchBar)findViewById(R.id.home_search_bar);
        searchBar.setInterceptMode(true);
        searchBar.setSearchButtonVisibility(View.GONE);
        searchBar.setOnInterceptClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
