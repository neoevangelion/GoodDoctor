package com.xywy.drug.ui.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xywy.drug.R;


public class SearchHistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_history, container, false);

        if (view != null && view instanceof ListView) {
            ListView listView = (ListView) view;

            View footer = inflater.inflate(R.layout.footer_search_history, null);
            listView.addFooterView(footer);

            ArrayAdapter<String> historyAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_search_history, R.id.search_history_text_view);
            listView.setAdapter(historyAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }

        return view;
    }
}
