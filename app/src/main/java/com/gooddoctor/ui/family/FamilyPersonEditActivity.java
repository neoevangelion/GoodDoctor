package com.gooddoctor.ui.family;

import android.app.Activity;
import android.os.Bundle;

import com.gooddoctor.R;


public class FamilyPersonEditActivity extends Activity {

    public static final String ACTION_FAMILY_PERSON_INSERT = "com.gooddoctor.family.INSERT";
    public static final String ACTION_FAMILY_PERSON_EDIT = "com.gooddoctor.family.EDIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_person_edit);
        String action = getIntent().getAction();
        if (action != null) {
            if (action.equals(ACTION_FAMILY_PERSON_INSERT)) {

            } else if (action.equals(ACTION_FAMILY_PERSON_EDIT)) {

            }
        }
    }
}
