package ir.kafpoosh;

/**
 * Created by Mohammad on 10/19/2017.
 */

public class RequestHistory {

    String _model;
    String _id;


    public RequestHistory(String model, String id) {
        this._model = model;
        this._id = id;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        this._model = model;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


}
