package com.xywy.drug.ui.medicine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.xywy.drug.R;
import com.zlianjie.framework.widget.CollapsibleMenu;

/**
 * Created by Administrator on 2014/8/10.
 */
public class MedicineCategoryMenu extends FrameLayout implements CollapsibleMenu, View.OnClickListener {

    public enum MedicineCategory {
        MEDICINE_CATEGORY_MEDICINE,
        MEDICINE_CATEGORY_HEALTH,
        MEDICINE_CATEGORY_INSTRUMENT,
        MEDICINE_CATEGORY_SEXUAL,
        MEDICINE_CATEGORY_BABY,
        MEDICINE_CATEGORY_BEAUTY
    }

    public interface OnCategoryClickListener {
        public void onClick(MedicineCategory category);
    }

    private OnCategoryClickListener mListener;

    public MedicineCategoryMenu(Context context) {
        super(context);
        initView();
    }

    public MedicineCategoryMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MedicineCategoryMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public void setOnCategoryClickListener(OnCategoryClickListener listener) {
        mListener = listener;
    }

    @Override
    public void collapse() {

    }

    @Override
    public void expand() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.medicine_category_medicine_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_MEDICINE);
                break;
            case R.id.medicine_category_health_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_HEALTH);
                break;
            case R.id.medicine_category_instrument_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_INSTRUMENT);
                break;
            case R.id.medicine_category_sexual_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_SEXUAL);
                break;
            case R.id.medicine_category_baby_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_BABY);
                break;
            case R.id.medicine_category_beauty_layout:
                notifyListener(MedicineCategory.MEDICINE_CATEGORY_BEAUTY);
                break;
            default:
                break;
        }
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View mainView = inflater.inflate(R.layout.view_medicine_category, this);

        View medicineView = mainView.findViewById(R.id.medicine_category_medicine_layout);
        View healthView = mainView.findViewById(R.id.medicine_category_health_layout);
        View instrumentView = mainView.findViewById(R.id.medicine_category_instrument_layout);
        View sexualView = mainView.findViewById(R.id.medicine_category_sexual_layout);
        View babyView = mainView.findViewById(R.id.medicine_category_baby_layout);
        View beautyView = mainView.findViewById(R.id.medicine_category_beauty_layout);

        medicineView.setOnClickListener(this);
        healthView.setOnClickListener(this);
        instrumentView.setOnClickListener(this);
        sexualView.setOnClickListener(this);
        babyView.setOnClickListener(this);
        beautyView.setOnClickListener(this);
    }

    private void notifyListener(MedicineCategory category) {
        if (mListener != null) {
            mListener.onClick(category);
        }
    }
}
