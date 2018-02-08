package com.user.paopao.main.login;

import com.user.paopao.base.BaseActivity;
import com.user.paopao.base.BasePresenter;
import com.user.paopao.base.BaseTask;
import com.user.paopao.base.BaseView;
import com.user.paopao.entity.LoginEntity;

import io.reactivex.Observer;

/**
 * author :kira
 * date: 2018/2/7.
 * description:
 */

public interface LoginContract {
    interface Task extends BaseTask {
        void login(String username, String passwod, Observer observer);
    }

    interface View extends BaseView {
        void loginSuccess(LoginEntity entity);

        void loginLogin();

    }

    abstract class Presenter extends BasePresenter<View, Task> {
        @Override
        public void onStart() {

        }

        abstract void login(String username, String passwod);

    }
}
