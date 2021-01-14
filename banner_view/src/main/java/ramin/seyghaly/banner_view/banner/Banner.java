package ramin.seyghaly.banner_view.banner;


import ramin.seyghaly.banner_view.core.AdsModel;
import ramin.seyghaly.banner_view.core.Type;

public class Banner extends AdsModel {

    private String url;
    private String title;

    public Banner() {
        super(Type.BANNER);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
