package com.xywy.drug.ui.medicine;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import com.xywy.drug.R;
import com.zlianjie.framework.widget.SideMenuView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MedicineCategoryListActivity extends Activity implements MedicineCategoryMenu.OnCategoryClickListener {

    @InjectView(R.id.medicine_category_side_menu_view)
    SideMenuView mContainer;

    private ListView mDetailView;
    private MedicineCategoryMenu mMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_category_list);

        ButterKnife.inject(this);

        mMenuView = new MedicineCategoryMenu(this);
        mDetailView = new ListView(this);

        mContainer.setMenuView(mMenuView);
        mContainer.setDetailView(mDetailView);

        mMenuView.setOnCategoryClickListener(this);
        mDetailView.setBackgroundColor(Color.RED);
    }


    @Override
    public void onClick(MedicineCategoryMenu.MedicineCategory category) {
        mContainer.collapseMenu();
    }
}
