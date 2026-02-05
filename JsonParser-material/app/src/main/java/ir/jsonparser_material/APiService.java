package ir.jsonparser_material;


import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JFP on 01-May-17.
 */

public interface APiService {

    @GET("/api/product.php")
    Call<List<Product>> getbookdetails();
    @GET("/api/product.php")
    Call<JSONArray> getsecondjson();

}