package com.user.paopao.main.home;

import com.user.paopao.base.BasePresenter;
import com.user.paopao.base.BaseTask;
import com.user.paopao.base.BaseView;
import com.user.paopao.entity.HomeEntity;
import com.user.paopao.entity.LoginEntity;

import java.util.List;

import io.reactivex.Observer;

/**
 * author :kira
 * date: 2018/2/7.
 * description:
 */

public interface HomeContract {
    interface Task extends BaseTask {
        void getData(String page, String column_num, String people_num, String order, String gender, Observer observer);


    }

    interface View extends BaseView {
        void getData(List<HomeEntity> list);

    }

    abstract class Presenter extends BasePresenter<View, Task> {
        @Override
        public void onStart() {

        }

        abstract void getData(String page, String column_num, String people_num, String order, String gender);


    }
}
