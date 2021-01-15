# Banner
How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ramin-seyghaly:Banner:0.0.1'
	}
Share this release:
[![](https://jitpack.io/v/ramin-seyghaly/Banner.svg)](https://jitpack.io/#ramin-seyghaly/Banner)

# How To Use Banner    
add Banner in xlm file

    <ramin.seyghaly.banner_view.views.BannerView
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:banner_padding="16dp"
        app:banner_titleTextSize="16sp"
        app:banner_titleTextColor="@color/purple_500"
        app:banner_selectedIndicatorColor="@color/purple_500"
        app:banner_unSelectedIndicatorColor="@color/black"
        app:banner_textBackgroundColor="#90C3BDBD"
        app:banner_radius="16dp"
        app:banner_slideDuration="10000"/>
	
get refrence and add banner

    BannerView bannerView = findViewById(R.id.banner);
    Banner banner = new Banner();
    banner.setUrl("https://static2.farakav.com/files/pictures/01561933.jpg");
    banner.setTitle("تست تیتر بنر سه");
    List<Banner> banners = new ArrayList<>();
    banners.add(banner);
    bannerView.addBanners(banners);
