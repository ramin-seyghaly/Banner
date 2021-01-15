package ramin.seyghaly.banner_view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ramin.seyghaly.banner_view.R;
import ramin.seyghaly.banner_view.sections.BannerViewHolder;
import ramin.seyghaly.banner_view.interfaces.OnBannerClickListener;
import ramin.seyghaly.banner_view.models.Banner;
import ramin.seyghaly.banner_view.models.BannerDesignInfo;


public class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    private List<Banner> banners;
    private BannerDesignInfo bannerDesignInfo;
    private OnBannerClickListener onBannerClickListener;

    public BannerAdapter(List<Banner> banners,BannerDesignInfo bannerDesignInfo,OnBannerClickListener onBannerClickListener) {
        this.banners = banners;
        this.bannerDesignInfo = bannerDesignInfo;
        this.onBannerClickListener = onBannerClickListener;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_banner, parent, false);
        return new BannerViewHolder(view,bannerDesignInfo,onBannerClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bind(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

}
