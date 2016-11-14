package carillegalquery.carillegalquery.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11/011.
 */

public class HomeYCHeadVPImg {


    private DataBean data;
    /**
     * data : {"itemList":[{"title":"踩刹车躲测速也会吃罚单！许多司机都在这里栽了跟头~","sourceUrl":null,"relatedItemId":519164,"relatedItemType":"article","imageUrl":"http://toutiao.image.mucang.cn/toutiao-image/2016/11/10/22/64d0217ea313494cb3aeb2fcd2b9edfa.jpeg","id":68280,"isManuel":false,"status":true},{"title":"支招99%司机想省油竟更费油，6个陋习你有吗？","sourceUrl":null,"relatedItemId":517224,"relatedItemType":"article","imageUrl":"http://toutiao.image.mucang.cn/toutiao-image/2016/11/10/19/bef28e3167b5423790a95e6666dab597.jpeg","id":68281,"isManuel":false,"status":true},{"title":"汽车漆面镀膜和封釉傻傻分不清数？你懂吗？","sourceUrl":null,"relatedItemId":515040,"relatedItemType":"article","imageUrl":"http://toutiao.image.mucang.cn/toutiao-image/2016/11/09/14/20bb553cf045415ca8b38d7d2a1d4bed.jpeg","id":68282,"isManuel":false,"status":true}]}
     * errorCode : 0
     * message : null
     * success : true
     */

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

        /**
         * title : 踩刹车躲测速也会吃罚单！许多司机都在这里栽了跟头~
         * sourceUrl : null
         * relatedItemId : 519164
         * relatedItemType : article
         * imageUrl : http://toutiao.image.mucang.cn/toutiao-image/2016/11/10/22/64d0217ea313494cb3aeb2fcd2b9edfa.jpeg
         * id : 68280
         * isManuel : false
         * status : true
         */

        private List<ItemListBean> itemList;

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean {

            private String title;
            private Object sourceUrl;
            private int relatedItemId;
            private String relatedItemType;
            private String imageUrl;
            private int id;
            private boolean isManuel;
            private boolean status;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getSourceUrl() {
                return sourceUrl;
            }

            public void setSourceUrl(Object sourceUrl) {
                this.sourceUrl = sourceUrl;
            }

            public int getRelatedItemId() {
                return relatedItemId;
            }

            public void setRelatedItemId(int relatedItemId) {
                this.relatedItemId = relatedItemId;
            }

            public String getRelatedItemType() {
                return relatedItemType;
            }

            public void setRelatedItemType(String relatedItemType) {
                this.relatedItemType = relatedItemType;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIsManuel() {
                return isManuel;
            }

            public void setIsManuel(boolean isManuel) {
                this.isManuel = isManuel;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }
        }
    }
}
/**
 * private int imgId;
 private String title;

 public HomeYCHeadVPImg() {
 }

 public HomeYCHeadVPImg(int imgId, String title) {
 this.imgId = imgId;
 this.title = title;
 }

 @Override
 public String toString() {
 return "HomeYCHeadVPImg{" +
 "imgId=" + imgId +
 ", title='" + title + '\'' +
 '}';
 }

 public int getImgId() {
 return imgId;
 }

 public void setImgId(int imgId) {
 this.imgId = imgId;
 }

 public String getTitle() {
 return title;
 }

 public void setTitle(String title) {
 this.title = title;
 }
 */
