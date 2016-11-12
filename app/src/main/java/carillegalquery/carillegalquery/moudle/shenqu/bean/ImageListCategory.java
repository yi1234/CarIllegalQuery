package carillegalquery.carillegalquery.moudle.shenqu.bean;

/**
 * Created by Administrator on 2016/11/10.
 */

public class ImageListCategory {
    private int height;

    private int width;
    private String url;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageListCategory(int height, int width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }

    public ImageListCategory() {
    }

    @Override
    public String toString() {
        return "ImageListCategory{" +
                "height=" + height +
                ", width=" + width +
                ", url='" + url + '\'' +
                '}';
    }
}
