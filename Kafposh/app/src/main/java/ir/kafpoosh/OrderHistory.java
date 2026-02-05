package ir.kafpoosh;

/**
 * Created by Mohammad on 10/19/2017.
 */

public class OrderHistory {

    String _model;
    String _dimension;
    String _status;
    String _id;


    public OrderHistory(String model, String dimension, String status, String id) {
        this._status = status;
        this._model = model;
        this._dimension = dimension;
        this._id = id;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        this._model = model;
    }

    public String getDimension() {
        return _dimension;
    }

    public void setDimension(String dimension) {
        this._dimension = dimension;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        this._status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


}
