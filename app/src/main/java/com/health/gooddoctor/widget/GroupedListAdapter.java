package com.health.gooddoctor.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


public class GroupedListAdapter<ChildDataType, GroupDataType> extends BaseAdapter {

    public enum GroupedListItemType {
        GROUPED_SINGLE_LIST_ITEM_VIEW,
        GROUPED_FIRST_LIST_ITEM_VIEW,
        GROUPED_MIDDLE_LIST_ITEM_VIEW_TYPE,
        GROUPED_LAST_LIST_ITEM_VIEW_TYPE
    }

    private GroupedListItemViewProvider<ChildDataType, GroupDataType> mListItemViewProvider;

    private List<GroupMetaData> mDataList;

    private int mItemCount;

    private class GroupMetaData {
        private GroupDataType mGroupData;
        private List<ChildDataType> mItemDataList;

        public GroupMetaData(GroupDataType groupData, List<ChildDataType> dataList) {
            mGroupData = groupData;
            mItemDataList = dataList;
        }

        public int getCount() {
            if (mItemDataList != null) {
                return mItemDataList.size();
            }
            return 0;
        }

        public GroupDataType getGroupData() {
            return mGroupData;
        }

        public ChildDataType getChildData(int position) {
            return mItemDataList.get(position);
        }
    }

    static private class GroupedIndex {
        public int groupIndex;
        public int childIndex;

        public static final int INVALID_CHILD_INDEX = -1;
    }

    public GroupedListAdapter(GroupedListItemViewProvider<ChildDataType, GroupDataType> provider) {
        mDataList = new ArrayList<GroupMetaData>();
        mListItemViewProvider = provider;
    }

    public void addGroup(int index, GroupDataType groupData, List<ChildDataType> childDataList) {
        GroupMetaData groupMetaData = new GroupMetaData(groupData, childDataList);
        mDataList.add(index, groupMetaData);
        mItemCount += (groupMetaData.getCount() + 1);
    }

    public void addGroup(GroupDataType groupData, List<ChildDataType> childDataList) {
        GroupMetaData groupMetaData = new GroupMetaData(groupData, childDataList);
        mDataList.add(groupMetaData);
        mItemCount += (groupMetaData.getCount() + 1);
    }

    public void removeGroup(int index) {
        GroupMetaData groupMetaData = mDataList.remove(index);
        mItemCount -= (groupMetaData.getCount() + 1);

    }

    @Override
    public int getCount() {
        return mItemCount;
    }

    @Override
    public Object getItem(int position) {
        GroupedIndex index = getUnflattenedPos(position);
        if (index.childIndex == GroupedIndex.INVALID_CHILD_INDEX) {
            return mDataList.get(index.groupIndex);
        } else {
            return mDataList.get(index.groupIndex).getChildData(index.childIndex);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GroupedIndex index = getUnflattenedPos(position);
        GroupMetaData groupMetaData = mDataList.get(index.groupIndex);

        if (index.childIndex == GroupedIndex.INVALID_CHILD_INDEX) {
            return mListItemViewProvider.getGroupView(index.groupIndex, convertView, groupMetaData.getGroupData(), parent);
        } else {
            GroupedListItemType type;
            if (groupMetaData.getCount() == 1) {
                type = GroupedListItemType.GROUPED_SINGLE_LIST_ITEM_VIEW;
            } else {
                if (index.childIndex == 0) {
                    type = GroupedListItemType.GROUPED_FIRST_LIST_ITEM_VIEW;
                } else if (index.childIndex == groupMetaData.getCount() - 1) {
                    type = GroupedListItemType.GROUPED_LAST_LIST_ITEM_VIEW_TYPE;
                } else {
                    type = GroupedListItemType.GROUPED_MIDDLE_LIST_ITEM_VIEW_TYPE;
                }
            }

            return mListItemViewProvider.getChildView(index.groupIndex, index.childIndex, convertView, groupMetaData.getChildData(index.childIndex), type, parent);
        }
    }

    private GroupedIndex getUnflattenedPos(int position) {
        if (position < 0 || position > mItemCount) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int groupIndex;

        GroupedIndex index = null;

        for (groupIndex = 0; groupIndex < mDataList.size(); ++ groupIndex) {
            GroupMetaData data = mDataList.get(groupIndex);
            if ((data.getCount() + 1) > position) {
                index = new GroupedIndex();

                index.groupIndex = groupIndex;
                index.childIndex = (position > 0) ? position - 1 : GroupedIndex.INVALID_CHILD_INDEX;
                break;
            }

            position -= (data.getCount() + 1);
        }

        return index;
    }
}
