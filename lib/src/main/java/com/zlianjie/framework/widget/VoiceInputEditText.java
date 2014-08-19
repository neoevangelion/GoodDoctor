package com.zlianjie.framework.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.EditText;

import com.baidu.voicerecognition.android.VoiceRecognitionConfig;
import com.baidu.voicerecognition.android.ui.BaiduASRDigitalDialog;
import com.baidu.voicerecognition.android.ui.DialogRecognitionListener;

import java.util.ArrayList;

public class VoiceInputEditText extends EditText implements DialogRecognitionListener {

    private String mApiKey;
    private String mSecretKey;

    public VoiceInputEditText(Context context) {
        super(context);
    }

    public VoiceInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VoiceInputEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setApiKey(String apiKey, String secretKey) {
        mApiKey = apiKey;
        mSecretKey = secretKey;
    }

    public BaiduASRDigitalDialog startVoiceInput() {
        Bundle params = new Bundle();
        params.putString(BaiduASRDigitalDialog.PARAM_API_KEY, mApiKey);
        params.putString(BaiduASRDigitalDialog.PARAM_SECRET_KEY, mSecretKey);
        params.putInt(BaiduASRDigitalDialog.PARAM_PROP, VoiceRecognitionConfig.PROP_INPUT);
        params.putString(BaiduASRDigitalDialog.PARAM_LANGUAGE, VoiceRecognitionConfig.LANGUAGE_CHINESE);
        params.putBoolean(BaiduASRDigitalDialog.PARAM_NLU_ENABLE, true);
        params.putInt(BaiduASRDigitalDialog.PARAM_DIALOG_THEME, BaiduASRDigitalDialog.THEME_GREEN_LIGHTBG);

        BaiduASRDigitalDialog dialog = new BaiduASRDigitalDialog(getContext(), params);
        dialog.setDialogRecognitionListener(this);
        dialog.show();

        return dialog;
    }

    @Override
    public void onResults(Bundle bundle) {
        ArrayList<String> array = bundle != null ? bundle.getStringArrayList(RESULTS_RECOGNITION) : null;
        if (array != null && array.size() > 0) {
            String str = array.get(0);
            setText(str);
        }
    }

}
