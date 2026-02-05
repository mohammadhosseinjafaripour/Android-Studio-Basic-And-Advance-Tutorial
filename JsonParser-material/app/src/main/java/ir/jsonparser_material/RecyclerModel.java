package ir.jsonparser_material;

/**
 * Created by jefferson on 10/18/2017.
 */

public class RecyclerModel {
    private String title;
    private String description;

    public RecyclerModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}