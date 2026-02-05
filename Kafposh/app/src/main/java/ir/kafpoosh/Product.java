package ir.kafpoosh;

public class Product {

    int _productid;
    String _title;
    String _model;
    String _imgUrl;
    String _dimension;
    String _status;

    public Product(int productid, String title, String model, String imgUrl) {
        this._productid = productid;
        this._title = title;
        this._model = model;
        this._imgUrl = imgUrl;
    }



    public int getProductid() {
        return _productid;
    }

    public void setProductid(int productid) {
        this._productid = productid;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
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

    public String getImageUrl() {
        return _imgUrl;
    }

    public void setImageUrl(String imageurl) {
        this._imgUrl = imageurl;
    }
}