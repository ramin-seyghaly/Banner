package ramin.seyghaly.banner_view.models;

import android.graphics.Typeface;

public class BannerDesignInfo {

    private Typeface bannerFontFamily;
    private int bannerTitleColor;
    private int textBackgroundColor;
    private float bannerTitleTextSize;
    private float bannerRadius;

    public Typeface getBannerFontFamily() {
        return bannerFontFamily;
    }

    public void setBannerFontFamily(Typeface bannerFontFamily) {
        this.bannerFontFamily = bannerFontFamily;
    }

    public int getBannerTitleColor() {
        return bannerTitleColor;
    }

    public void setBannerTitleColor(int bannerTitleColor) {
        this.bannerTitleColor = bannerTitleColor;
    }

    public float getBannerTitleTextSize() {
        return bannerTitleTextSize;
    }

    public void setBannerTitleTextSize(float bannerTitleTextSize) {
        this.bannerTitleTextSize = bannerTitleTextSize;
    }

    public int getTextBackgroundColor() {
        return textBackgroundColor;
    }

    public void setTextBackgroundColor(int textBackgroundColor) {
        this.textBackgroundColor = textBackgroundColor;
    }

    public float getBannerRadius() {
        return bannerRadius;
    }

    public void setBannerRadius(float bannerRadius) {
        this.bannerRadius = bannerRadius;
    }

}
