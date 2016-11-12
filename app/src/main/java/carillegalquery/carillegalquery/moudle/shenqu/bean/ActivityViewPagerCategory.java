package carillegalquery.carillegalquery.moudle.shenqu.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

public class ActivityViewPagerCategory {

    private DataBean data;

    private int errorCode;
    private Object message;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        private List<?> hot;


        private List<FocusBean> focus;

        public List<?> getHot() {
            return hot;
        }

        public void setHot(List<?> hot) {
            this.hot = hot;
        }

        public List<FocusBean> getFocus() {
            return focus;
        }

        public void setFocus(List<FocusBean> focus) {
            this.focus = focus;
        }

        public static class FocusBean {
            private String activityUrl;
            private String imageUrl;

            public String getActivityUrl() {
                return activityUrl;
            }

            public void setActivityUrl(String activityUrl) {
                this.activityUrl = activityUrl;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }
    }
}
