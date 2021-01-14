package ramin.seyghaly.banner_view.core;


import ramin.seyghaly.banner_view.actions.Action;

public class AdsModel {

    private String id;
    private Action action = Action.NONE;
    private Type type;
    private Object data;
    private Object subData;

    public AdsModel(Type type){
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getSubData() {
        return subData;
    }

    public void setSubData(Object subData) {
        this.subData = subData;
    }

}
