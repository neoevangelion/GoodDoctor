package com.gooddoctor.ui.disease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gooddoctor.R;
import com.gooddoctor.data.gson.DiseaseCategory;
import com.gooddoctor.data.gson.DiseaseResultData;

/**
 * Created by eWalk_iOS on 14-8-11.
 */
public class DiseaseListAdapter extends BaseExpandableListAdapter {

    private DiseaseResultData mData;
    private LayoutInflater mInflater;
    private String mDetailSplit;

    public DiseaseListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mDetailSplit = context.getString(R.string.disease_activity_split);
    }

    public void setData(DiseaseResultData data) {
        mData = data;
    }

    public DiseaseResultData getData() {
        return mData;
    }

    @Override
    public int getGroupCount() {
        return (mData != null) ? mData.getList().size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (mData != null) ? mData.getList().get(groupPosition).getContent().size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return (mData != null) ? mData.getList().get(groupPosition) : null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return (mData != null) ? mData.getList().get(groupPosition).getContent().get(childPosition) : null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_disease_category, parent, false);
            GroupViewHolder viewHolder = new GroupViewHolder();
            viewHolder.mImageView = (ImageView)convertView.findViewById(R.id.disease_category_list_item_image);
            viewHolder.mTitleView = (TextView)convertView.findViewById(R.id.disease_category_list_item_title);
            viewHolder.mDetailView = (TextView)convertView.findViewById(R.id.disease_category_list_item_detail);

            convertView.setTag(viewHolder);
        }

        GroupViewHolder viewHolder = (GroupViewHolder)convertView.getTag();
        viewHolder.mTitleView.setText(mData.getList().get(groupPosition).getTitle());

        DiseaseCategory category = mData.getList().get(groupPosition);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3 && i < category.getContent().size(); ++ i) {
            stringBuilder.append(category.getContent().get(i).getName());
            if (i < 2 && i < category.getContent().size() - 1) {
                stringBuilder.append(mDetailSplit);
            }
        }
        viewHolder.mDetailView.setText(stringBuilder.toString());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_disease, parent, false);
            ChildViewHolder viewHolder = new ChildViewHolder();

            viewHolder.mTitleView = (TextView)convertView.findViewById(R.id.disease_list_item_title);

            convertView.setTag(viewHolder);
        }

        ChildViewHolder viewHolder = (ChildViewHolder)convertView.getTag();
        viewHolder.mTitleView.setText(mData.getList().get(groupPosition).getContent().get(childPosition).getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class GroupViewHolder {
        public ImageView mImageView;
        public TextView mTitleView;
        public TextView mDetailView;
    }

    private class ChildViewHolder {
        public TextView mTitleView;
    }
}
