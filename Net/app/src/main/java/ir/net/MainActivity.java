package ir.net;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.artjimlop.altex.AltexImageDownloader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setTitle("Loading");
       // progressDialog.show();
        progressDialog.setCancelable(false);
        final ImageView img =(ImageView)findViewById(R.id.imageView);





    }

}
