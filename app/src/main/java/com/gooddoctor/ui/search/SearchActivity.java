package com.gooddoctor.ui.search;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.gooddoctor.R;
import com.gooddoctor.engine.search.SearchEngine;
import com.gooddoctor.engine.search.SearchResult;
import com.gooddoctor.engine.search.SearchResultListener;
import com.tuyuanlin.framework.widget.SearchBar;
import com.tuyuanlin.framework.widget.SearchBarActionHandler;
import com.tuyuanlin.framework.widget.TitleBar;


public class SearchActivity extends FragmentActivity {

    private static final int PAGE_SIZE  = 10;

    private SearchBar mSearchBar;
    private SearchHistoryFragment mSearchHistoryFragment;
    private SearchResultFragment mSearchResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TitleBar titleBar = (TitleBar)findViewById(R.id.search_result_title_bar);
        titleBar.setBackButtonVisibility(View.GONE);
        mSearchBar = new SearchBar(this);
        mSearchBar.setSearchActionHandler(new SearchBarActionHandler() {
            @Override
            public void onSearch(String keyword) {
                doSearch(keyword);
            }

            @Override
            public void onCancel() {
                finish();
            }
        });

        titleBar.setCenterView(mSearchBar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mSearchHistoryFragment = new SearchHistoryFragment();
        mSearchResultFragment = new SearchResultFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.search_fragment_layout, mSearchHistoryFragment);
        transaction.add(R.id.search_fragment_layout, mSearchResultFragment);
        transaction.show(mSearchHistoryFragment);
        transaction.hide(mSearchResultFragment);
        transaction.commit();
    }

    private void doSearch(String keyword) {
        SearchEngine engine = SearchEngine.getInstance(this);
        engine.searchMedicineByKeyword(keyword, PAGE_SIZE, 0, mSearchResultListener);
    }

    private SearchResultListener mSearchResultListener = new SearchResultListener() {
        @Override
        public void handleSearchResult(SearchResult result) {
            mSearchResultFragment.updateSearchResult(result);

            if (!mSearchResultFragment.isVisible()) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(mSearchHistoryFragment);
                transaction.show(mSearchResultFragment);
                transaction.commit();
            }
        }
    };
}
