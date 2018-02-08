package com.user.paopao.utils;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 控件的处理
 */
public class EditUtils {

    public static String getEditTextContent(EditText edt){
        return edt.getEditableText().toString().trim();
    }


    /**
     * 判断是否为空
     * @param edts
     * @return
     */
    public static boolean isEmpty(EditText... edts){
        for (EditText edt: edts) {
            if(TextUtils.isEmpty(edt.getText().toString().trim())){
                return true;
            }
        }
        return false;
    }
}
