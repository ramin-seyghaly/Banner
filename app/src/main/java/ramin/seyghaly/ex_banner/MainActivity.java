package ramin.seyghaly.ex_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ramin.seyghaly.banner_view.models.Banner;
import ramin.seyghaly.banner_view.views.BannerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BannerView bannerView = findViewById(R.id.banner);
        Banner banner = new Banner();
        banner.setUrl("https://static2.farakav.com/files/pictures/01561933.jpg");
        banner.setTitle("تست تیتر بنر سه");
        List<Banner> banners = new ArrayList<>();
        banners.add(banner);
        bannerView.addBanners(banners);
    }
}