package ramin.seyghaly.banner_view.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import ramin.seyghaly.banner_view.R;
import ramin.seyghaly.banner_view.core.AdsObserverController;
import ramin.seyghaly.banner_view.tools.Tools;


public class AdsBanner extends RelativeLayout implements OnBannerClickListener {

    private View view;
    private ViewPager2 mPager;
    private BannerAdapter adapter;
    private LinearLayout layoutOnBoardinIndicators;
    private LinearLayout.LayoutParams layoutParams;
    private List<Banner> banners = new ArrayList<>();
    private Handler slideHandler = new Handler(Looper.getMainLooper());
    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                if (!banners.isEmpty()) {
                    if (mPager.getCurrentItem() == banners.size() - 1) {
                        mPager.setCurrentItem(0);
                    } else {
                        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                    }
                }
            }catch (Exception e){}
        }
    };
    private float scaleRatio;
    private float bannerPadding;
    private float bannerTitleTextSize;
    private int bannerTitleColor;
    private int bannerSelectedIndicatorColor;
    private int bannerUnSelectedIndicatorColor;
    private int bannerTextBackgroundColor;
    private float bannerRadius;
    private long bannerSlideDuration = 3000;
    private Typeface bannerFontFamily;
    private BannerDesignInfo bannerDesignInfo = new BannerDesignInfo();

    public AdsBanner(Context context) {
        super(context);
        init(context,null);
    }

    public AdsBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public AdsBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public AdsBanner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightRatio = (heightMeasureSpec * 9)/16;
        super.onMeasure(widthMeasureSpec, heightRatio);
    }

    private void init(Context context,AttributeSet attrs){
        bindDefaultValue(context);
        initAttrs(attrs);
        setBannerDesignInfo();
        initView(context);
    }

    private void bindDefaultValue(Context context) {
        scaleRatio = getResources().getDisplayMetrics().density;
        bannerPadding = 0;
        bannerTitleTextSize = Tools.convertSptoPixel(context,16);
        bannerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, getContext().getResources().getDisplayMetrics());
        bannerTitleColor = Tools.getColor(context,R.color.title_color);
        bannerSelectedIndicatorColor = Tools.getColor(context,R.color.grey);
        bannerUnSelectedIndicatorColor = Tools.getColor(context,R.color.white);
        bannerTextBackgroundColor = Tools.getColor(context,R.color.transparent);
        //bannerFontFamily = ResourcesCompat.getFont(getContext(), R.font.custom_font_use);
    }

    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.AdsBanner, 0, 0);
            try {
                int slideDurationStyle = R.styleable.AdsBanner_banner_slideDuration;
                if (typedArray.hasValue(slideDurationStyle)) {
                    bannerSlideDuration = typedArray.getInteger(slideDurationStyle, (int) bannerSlideDuration);
                }
                //region dimension
                int radiusStyle = R.styleable.AdsBanner_banner_radius;
                if (typedArray.hasValue(radiusStyle)) {
                    bannerRadius = typedArray.getDimensionPixelSize(radiusStyle, (int) bannerRadius);
                }
                int paddingStyle = R.styleable.AdsBanner_banner_padding;
                if (typedArray.hasValue(paddingStyle)) {
                    bannerPadding = typedArray.getDimensionPixelSize(paddingStyle, (int) bannerPadding);
                }
                int titleTextSizeStyle = R.styleable.AdsBanner_banner_titleTextSize;
                if (typedArray.hasValue(titleTextSizeStyle)) {
                    bannerTitleTextSize = typedArray.getDimensionPixelSize(titleTextSizeStyle, (int) bannerTitleTextSize);
                }
                //endregion
                //region color
                int textBackgroundColorStyle = R.styleable.AdsBanner_banner_textBackgroundColor;
                if (typedArray.hasValue(textBackgroundColorStyle)) {
                    bannerTextBackgroundColor = typedArray.getColor(textBackgroundColorStyle, bannerTextBackgroundColor);
                }
                int unSelectedIndicatorColorStyle = R.styleable.AdsBanner_banner_unSelectedIndicatorColor;
                if (typedArray.hasValue(unSelectedIndicatorColorStyle)) {
                    bannerUnSelectedIndicatorColor = typedArray.getColor(unSelectedIndicatorColorStyle, bannerUnSelectedIndicatorColor);
                }
                int selectedIndicatorColorStyle = R.styleable.AdsBanner_banner_selectedIndicatorColor;
                if (typedArray.hasValue(selectedIndicatorColorStyle)) {
                    bannerSelectedIndicatorColor = typedArray.getColor(selectedIndicatorColorStyle, bannerSelectedIndicatorColor);
                }
                int titleColorStyle = R.styleable.AdsBanner_banner_titleTextColor;
                if (typedArray.hasValue(titleColorStyle)) {
                    bannerTitleColor = typedArray.getColor(titleColorStyle, bannerTitleColor);
                }
                //endregion
                //region font
                int fontFamilyStyle = R.styleable.AdsBanner_banner_fontFamily;
                if (typedArray.hasValue(fontFamilyStyle)) {
                    int font = typedArray.getResourceId(fontFamilyStyle, 0);
                    if (font > 0) {
                        bannerFontFamily = ResourcesCompat.getFont(getContext(), font);
                    }
                }
                //endregion
            } finally {
                typedArray.recycle();
            }
        }
    }

    private void setBannerDesignInfo(){
        bannerDesignInfo.setBannerFontFamily(bannerFontFamily);
        bannerDesignInfo.setBannerTitleColor(bannerTitleColor);
        bannerDesignInfo.setBannerTitleTextSize(bannerTitleTextSize);
        bannerDesignInfo.setTextBackgroundColor(bannerTextBackgroundColor);
        bannerDesignInfo.setBannerRadius(bannerRadius);
    }

    private void initView(Context context){
        view = LayoutInflater.from(context).inflate(R.layout.view_ads_banner, null, false);
        mPager = view.findViewById(R.id.viewpager);
        mPager.setPadding((int) bannerPadding,0,(int) bannerPadding,0);
        adapter = new BannerAdapter(banners,bannerDesignInfo,this);
        mPager.setAdapter(adapter);
        mPager.setClipToPadding(false);
        mPager.setClipChildren(false);
        mPager.setOffscreenPageLimit(3);
        mPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(16));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        mPager.setPageTransformer(compositePageTransformer);
        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(slideRunnable);
                slideHandler.postDelayed(slideRunnable,bannerSlideDuration);
                setCurrentIndicator(position);
            }
        });
        layoutParams = new LinearLayout.LayoutParams(
                16, 16
        );
        layoutParams.setMargins(8,0,8,0);
        layoutOnBoardinIndicators = view.findViewById(R.id.rootIndicator);
        addView(view);
    }

    private void setCurrentIndicator(int index){
        int childCount = layoutOnBoardinIndicators.getChildCount();
        for (int i = 0 ; i < childCount ; i++){
            ImageView imageView = (ImageView) layoutOnBoardinIndicators.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.selected_pager_dot));
                imageView.setColorFilter(bannerSelectedIndicatorColor, android.graphics.PorterDuff.Mode.SRC_IN);
            }else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.unselected_pager_dot));
                imageView.setColorFilter(bannerUnSelectedIndicatorColor, android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public void addBanner(Banner banner){
        slideHandler.removeCallbacks(slideRunnable);
        banners.add(banner);
        update();
    }

    public void addBanners(List<Banner> banners){
        slideHandler.removeCallbacks(slideRunnable);
        this.banners.addAll(banners);
        update();
    }

    public void clear(){
        slideHandler.removeCallbacks(slideRunnable);
        banners.clear();
        update();
    }

    public void onPause(){
        slideHandler.removeCallbacks(slideRunnable);
    }

    public void onResume(){
        slideHandler.postDelayed(slideRunnable,bannerSlideDuration);
    }

    private void update(){
        try {
            layoutOnBoardinIndicators.removeAllViews();
            ImageView[] indicator = new ImageView[banners.size()];
            for (int i = 0 ; i < indicator.length ; i++){
                indicator[i] = new ImageView(getContext());
                indicator[i].setImageDrawable(
                        ContextCompat.getDrawable(getContext(),R.drawable.unselected_pager_dot)
                );
                indicator[i].setLayoutParams(layoutParams);
                layoutOnBoardinIndicators.addView(indicator[i]);
            }
            setCurrentIndicator(0);
            adapter.notifyDataSetChanged();
            if (!banners.isEmpty()){
                slideHandler.postDelayed(slideRunnable,bannerSlideDuration);
            }
        }catch (Exception e){}
    }

    @Override
    public void onBannerClick(Banner banner) {
        if (getContext() != null){
            AdsObserverController.getInstance().onAdsClick(banner);
        }
    }

}
