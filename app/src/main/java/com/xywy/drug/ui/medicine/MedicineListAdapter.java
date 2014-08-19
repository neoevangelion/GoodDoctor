package com.xywy.drug.ui.medicine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xywy.drug.R;
import com.xywy.drug.data.gson.Medicine;

import java.util.List;


/**
 * Created by Administrator on 2014/8/10.
 */
public class MedicineListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Medicine> mData;

    public MedicineListAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Medicine> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return (mData != null) ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            ViewHolder viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_medicine, parent, false);
            viewHolder.mTitleView = (TextView) convertView.findViewById(R.id.medicine_list_item_title_text_view);
            viewHolder.mPriceView = (TextView) convertView.findViewById(R.id.medicine_list_item_price_text_view);
            viewHolder.mCompanyView = (TextView) convertView.findViewById(R.id.medicine_list_item_company_text_view);
            viewHolder.mDescriptionView = (TextView) convertView.findViewById(R.id.medicine_list_item_description_text_view);
            viewHolder.mSellerView = (TextView) convertView.findViewById(R.id.medicine_list_item_sellers_text_view);
            viewHolder.mOtcImage = (ImageView) convertView.findViewById(R.id.medicine_list_item_otc_image);
            viewHolder.mNonOtcImage = (ImageView) convertView.findViewById(R.id.medicine_list_item_non_otc_image);

            convertView.setTag(viewHolder);
        }

        return convertView;
    }

    private class ViewHolder {
        public TextView mTitleView;
        public TextView mCompanyView;
        public TextView mPriceView;
        public TextView mDescriptionView;
        public TextView mSellerView;
        public ImageView mOtcImage;
        public ImageView mNonOtcImage;

    }
}
