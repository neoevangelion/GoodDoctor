package com.gooddoctor.ui.medicine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gooddoctor.R;
import com.gooddoctor.data.dao.Medicine;

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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_medicine, parent, false);
            TextView titleText = (TextView) convertView.findViewById(R.id.medicine_list_item_title_text_view);
            TextView priceText = (TextView) convertView.findViewById(R.id.medicine_list_item_price_text_view);
            TextView companyText = (TextView) convertView.findViewById(R.id.medicine_list_item_company_text_view);
            TextView descriptionText = (TextView) convertView.findViewById(R.id.medicine_list_item_description_text_view);
            TextView sellersText = (TextView) convertView.findViewById(R.id.medicine_list_item_sellers_text_view);
            ImageView otcImage = (ImageView) convertView.findViewById(R.id.medicine_list_item_otc_image);
            ImageView nonOtcImage = (ImageView) convertView.findViewById(R.id.medicine_list_item_non_otc_image);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mTitleView = titleText;
            viewHolder.mCompanyView = companyText;
        }

        Medicine medicine = (Medicine) getItem(position);
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
