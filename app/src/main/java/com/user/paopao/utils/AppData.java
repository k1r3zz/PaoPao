package com.user.paopao.utils;

import com.user.paopao.Constant;
import com.user.paopao.entity.LoginEntity;


/**
 * author :kira
 * date: 2018/1/30.
 * description:
 */

public class AppData {

    public static LoginEntity getLogin() {
        LoginEntity loginEntity = (LoginEntity) SharePrefrencesUtil.getInstance().getObject(Constant.KEY_LOGIN_ENTITY);
        return loginEntity;
    }

}
