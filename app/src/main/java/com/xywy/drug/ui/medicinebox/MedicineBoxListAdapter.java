package com.xywy.drug.ui.medicinebox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xywy.drug.data.dao.DBMedicineBox;

import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-20.
 */
public class MedicineBoxListAdapter extends BaseAdapter {
    private Context mContext;
    private List<DBMedicineBox> mData;

    public MedicineBoxListAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<DBMedicineBox> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
