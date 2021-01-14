# Banner
To get a Git project into your build:

# Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
# Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ramin-seyghaly:Ads:1.0.3'
	}
# How To Use Banner
-initialize Ads in Base Activity

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        Ads.init(this);
    }
    
-add Ads life Cycle
    
    @Override
    protected void onResume() {
        super.onResume();
        Ads.getInstance().onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Ads.getInstance().onPause();
    }
    
-add Banner in xlm file

    <ramin.seyghaly.ads.banner.AdsBanner
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:banner_padding="16dp"
        app:banner_titleTextSize="16sp"
        app:banner_titleTextColor="@color/purple_500"
        app:banner_fontFamily="@font/custom_font_use"
        app:banner_selectedIndicatorColor="@color/purple_500"
        app:banner_unSelectedIndicatorColor="@color/black"
        app:banner_textBackgroundColor="#90C3BDBD"
        app:banner_radius="16dp"
        app:banner_slideDuration="10000"/>
	
-get refrence and add banner

    adsBanner = findViewById(R.id.banner);
    Banner banner = new Banner();
    banner.setUrl("https://static2.farakav.com/files/pictures/01561933.jpg");
    banner.setTitle("تست تیتر بنر سه");
    banner.setAction(Action.CALL);
    banner.setData("+989016280758");
    List<Banner> banners = new ArrayList<>();
    banners.add(banner);
    adsBanner.addBanners(banners);
