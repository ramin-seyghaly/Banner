package ramin.seyghaly.banner_view.models;

import android.graphics.Typeface;

import ramin.seyghaly.banner_view.types.GravityType;

public class BannerDesignInfo {

    private Typeface bannerFontFamily;
    private int bannerTitleColor;
    private int bannerTitleBackgroundColor;
    private int bannerStrokeColor;
    private float bannerTitleTextSize;
    private float bannerRadius;
    private float bannerStrokeWidth;
    private GravityType bannerTitleGravity;

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

    public float getBannerRadius() {
        return bannerRadius;
    }

    public void setBannerRadius(float bannerRadius) {
        this.bannerRadius = bannerRadius;
    }

    public GravityType getBannerTitleGravity() {
        return bannerTitleGravity;
    }

    public void setBannerTitleGravity(GravityType bannerTitleGravity) {
        this.bannerTitleGravity = bannerTitleGravity;
    }

    public int getBannerTitleBackgroundColor() {
        return bannerTitleBackgroundColor;
    }

    public void setBannerTitleBackgroundColor(int bannerTitleBackgroundColor) {
        this.bannerTitleBackgroundColor = bannerTitleBackgroundColor;
    }

    public int getBannerStrokeColor() {
        return bannerStrokeColor;
    }

    public void setBannerStrokeColor(int bannerStrokeColor) {
        this.bannerStrokeColor = bannerStrokeColor;
    }

    public float getBannerStrokeWidth() {
        return bannerStrokeWidth;
    }

    public void setBannerStrokeWidth(float bannerStrokeWidth) {
        this.bannerStrokeWidth = bannerStrokeWidth;
    }
}
