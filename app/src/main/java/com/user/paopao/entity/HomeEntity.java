package com.user.paopao.entity;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/8.
 * description:
 */

public class HomeEntity {

    /**
     * id : 2
     * title : 类型二
     * users : [{"uid":"1","info":{"nickname":"xcb2","headpic":null}}]
     */

    private String id;
    private String title;
    private List<UsersBean> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public static class UsersBean {
        /**
         * uid : 1
         * info : {"nickname":"xcb2","headpic":null}
         */

        private String uid;
        private InfoBean info;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * nickname : xcb2
             * headpic : null
             */

            private String nickname;
            private Object headpic;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Object getHeadpic() {
                return headpic;
            }

            public void setHeadpic(Object headpic) {
                this.headpic = headpic;
            }
        }
    }
}


