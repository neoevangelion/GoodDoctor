package com.gooddoctor.widget;

import android.view.View;
import android.view.ViewGroup;

public interface GroupedListItemViewProvider <ChildDataType, GroupDataType> {

    public View getChildView(int groupIndex, int childIndex, View convertView, ChildDataType data, GroupedListAdapter.GroupedListItemType type, ViewGroup parent);

    public View getGroupView(int groupIndex, View convertView, GroupDataType data, ViewGroup parent);
}
