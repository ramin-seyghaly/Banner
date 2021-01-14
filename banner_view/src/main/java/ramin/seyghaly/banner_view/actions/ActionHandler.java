package ramin.seyghaly.banner_view.actions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.webkit.URLUtil;

import ramin.seyghaly.banner_view.core.Ads;
import ramin.seyghaly.banner_view.core.AdsModel;
import ramin.seyghaly.banner_view.core.AdsObserver;
import ramin.seyghaly.banner_view.core.Type;


public class ActionHandler implements AdsObserver.Delegate {

    private final AdsObserver.Delegate delegate = this;
    private Activity activity;
    private Ads.OnAddEventListener onAddEventListener;

    public ActionHandler(Activity activity){
        this.activity = activity;
    }

    public void setOnAddEventListener(Ads.OnAddEventListener onAddEventListener) {
        this.onAddEventListener = onAddEventListener;
    }

    public AdsObserver.Delegate getDelegate() {
        return delegate;
    }

    @Override
    public void onActionEvent(AdsModel adsModel) {
        if (adsModel != null && adsModel.getAction() != null)
            switch (adsModel.getAction()){
                case OPEN_BROWSER:
                    if (adsModel.getData() != null && adsModel.getData() instanceof String) {
                        openBrowser(activity, (String) adsModel.getData(),adsModel.getType());
                    }
                    break;
                case CALL:
                    if (adsModel.getData() != null && adsModel.getData() instanceof String) {
                        openCall(activity, (String) adsModel.getData(),adsModel.getType());
                    }
                    break;
                case SMS:
                    if (adsModel.getData() != null && adsModel.getData() instanceof String) {
                        openSms(activity, (String) adsModel.getData(), (String) adsModel.getSubData(),adsModel.getType());
                    }
                    break;
            }
    }

    private void openBrowser(Activity activity, String data, Type type){
        if (activity != null && URLUtil.isValidUrl(data)) {
            message("Start the browser to open this link " + data,type,true);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(data));
            activity.startActivity(i);
        }else {
            message("The browser could not be opened, The link may not be valid",type,false);
        }
    }

    private void openCall(Activity activity,String data,Type type){
        if (activity != null && PhoneNumberUtils.isGlobalPhoneNumber(data)) {
            message("Start call this number " + data,type,true);
            String phone = data;
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            activity.startActivity(intent);
        }else {
            message("Cannot be called, The number may not be valid",type,false);
        }
    }

    private void openSms(Activity activity,String data,String subData,Type type){
        if (activity != null && PhoneNumberUtils.isGlobalPhoneNumber(data)) {
            message("Start sms this number " + data,type,true);
            Intent I =new Intent(Intent.ACTION_VIEW);
            I.setType("vnd.android-dir/mms-sms");
            I.setData(Uri.parse("smsto:"));
            String message = "";
            if (subData != null){
                message = subData;
            }
            I.putExtra("address", new String (data));
            I.putExtra("sms_body",message);
            activity.startActivity(I);
        }else {
            message("Cannot be sms, The number may not be valid",type,false);
        }
    }

    private void message(String msg, Type type, boolean isNotError){
        if (onAddEventListener != null && type != null){
            String message = type.getValue() + " - " + msg;
            if (isNotError){
                onAddEventListener.onAdEvent(message);
            }else {
                onAddEventListener.onAdEvent(message);
            }
        }
    }

}
