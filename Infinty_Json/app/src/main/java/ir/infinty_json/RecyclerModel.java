package ir.infinty_json;

import android.media.Image;

/**
 * Created by jefferson on 10/18/2017.
 */

public class RecyclerModel {
    private String title;
    private String description;
    private String imageurl;

    public RecyclerModel(String id, String image) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}