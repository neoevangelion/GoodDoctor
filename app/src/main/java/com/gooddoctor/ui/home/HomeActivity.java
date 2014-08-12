package com.gooddoctor.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.gooddoctor.R;
import com.gooddoctor.ui.search.SearchActivity;
import com.tuyuanlin.customwidget.SearchBar;


import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeActivity extends FragmentActivity {

    @InjectView(R.id.home_search_bar)
    SearchBar mSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.home_fragment_layout, fragment);
        transaction.show(fragment);
        transaction.commit();

        mSearchBar.setInterceptMode(true);
        mSearchBar.setSearchButtonVisibility(View.GONE);
        mSearchBar.setOnInterceptClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
