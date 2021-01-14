package ramin.seyghaly.banner_view.core;

import android.app.Activity;

import ramin.seyghaly.banner_view.actions.ActionHandler;
import ramin.seyghaly.banner_view.exceptions.AdsException;


public class Ads{

    private static Ads ads;
    private AdsObserver observer;
    private ActionHandler actionHandler;

    public interface OnAddEventListener{
        void onAdEvent(String msg);
        void onAdError(String msg);
    }

    public void setOnAddEventListener(OnAddEventListener onAddEventListener) {
        actionHandler.setOnAddEventListener(onAddEventListener);
    }

    public static void init(Activity activity) {
        if (ads == null){
            ads = new Ads(activity);
        }
    }

    public static Ads getInstance() {
        if (ads == null){
            throw new AdsException(AdsException.INITIALIZE_EXCEPTION);
        }
        return ads;
    }

    private Ads(Activity activity){
        actionHandler = new ActionHandler(activity);
        observer = new AdsObserver(actionHandler.getDelegate());
        AdsObserverController.getInstance().registerObserver(observer);
    }

    public void onPause(){
        if (ads != null) {
            AdsObserverController.getInstance().unRegisterObserver(observer);
        }
    }

    public void onResume(){
        if (ads != null) {
            AdsObserverController.getInstance().registerObserver(observer);
        }
    }

}
