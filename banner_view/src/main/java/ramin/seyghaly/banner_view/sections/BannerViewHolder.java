package ramin.seyghaly.banner_view.sections;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import ramin.seyghaly.banner_view.R;
import ramin.seyghaly.banner_view.interfaces.OnBannerClickListener;
import ramin.seyghaly.banner_view.models.Banner;
import ramin.seyghaly.banner_view.models.BannerDesignInfo;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class BannerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnBannerClickListener onBannerClickListener;
    private BannerDesignInfo bannerDesignInfo;
    private AppCompatImageView image;
    private AppCompatTextView titleTextView;
    private CardView bannerCardView;
    private Context context;
    private Banner banner;

    public BannerViewHolder(@NonNull View itemView, BannerDesignInfo bannerDesignInfo,OnBannerClickListener onBannerClickListener) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        itemView.findViewById(R.id.root).setOnClickListener(this);
        context = itemView.getContext();
        this.onBannerClickListener = onBannerClickListener;
        titleTextView = itemView.findViewById(R.id.title);
        bannerCardView = itemView.findViewById(R.id.bannerCardView);
        this.bannerDesignInfo = bannerDesignInfo;
    }

    private void clear() {
        Glide.with(this.context).clear(image);
    }

    public void bind(Banner banner) {
        this.banner = banner;
        clear();
        if (banner != null && banner.getUrl() != null) {
            Glide.with(this.context).asBitmap().load(banner.getUrl()).override(Target.SIZE_ORIGINAL).centerCrop().into(image);
        }
        if (bannerDesignInfo != null) {
            if (bannerDesignInfo.getBannerFontFamily() != null) {
                titleTextView.setTypeface(bannerDesignInfo.getBannerFontFamily());
            }
            titleTextView.setTextColor(bannerDesignInfo.getBannerTitleColor());
            titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, bannerDesignInfo.getBannerTitleTextSize());
            titleTextView.setBackgroundColor(bannerDesignInfo.getTextBackgroundColor());
            bannerCardView.setRadius(bannerDesignInfo.getBannerRadius());
        }
        if (banner != null && banner.getTitle() != null) {
            titleTextView.setText(banner.getTitle());
            titleTextView.setVisibility(VISIBLE);
        }else {
            titleTextView.setText("");
            titleTextView.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.root && onBannerClickListener != null && banner != null){
            onBannerClickListener.onBannerClicked(banner);
        }
    }

}
