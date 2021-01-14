package ramin.seyghaly.banner_view.core;

import java.util.Observable;
import java.util.Observer;

import ramin.seyghaly.banner_view.exceptions.AdsException;


public class AdsObserverController extends Observable {

    private static AdsObserverController adsObserverController;

    public static AdsObserverController getInstance(){
        if (adsObserverController == null){
            adsObserverController = new AdsObserverController();
        }
        return adsObserverController;
    }

    private AdsObserverController() {}

    public void onAdsClick(AdsModel adsModel){
        if (adsModel != null) {
            if(countObservers() == 0){
                throw new AdsException(AdsException.INITIALIZE_EXCEPTION);
            }
            setChanged();
            notifyObservers(adsModel);
        }
    }

    public void registerObserver(Observer observer){
        addObserver(observer);
    }

    public void unRegisterObserver(Observer observer){
        deleteObserver(observer);
    }

}