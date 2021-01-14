package ramin.seyghaly.banner_view.core;

import java.util.Observable;
import java.util.Observer;

public class AdsObserver implements Observer {

    private Delegate delegate;

    public interface Delegate{
        void onActionEvent(AdsModel adsModel);
    }

    public AdsObserver(Delegate actionDelegate) {
        this.delegate = actionDelegate;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof AdsModel) {
            delegate.onActionEvent((AdsModel) arg);
        }
    }

}