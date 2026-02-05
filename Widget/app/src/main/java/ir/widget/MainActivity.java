package ir.widget;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import su.whs.watl.text.TextLine;
import su.whs.watl.text.Utils;
import su.whs.watl.ui.TextViewEx;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.support.v4.content.FileProvider.getUriForFile;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewEx tx = (TextViewEx) findViewById(R.id.wow);
        tx.setText("Long Text Programchi.ir ....");




        Toast.makeText(this, ""+getInputStreamFromUrl("http://programchi.ir/getip.php"), Toast.LENGTH_SHORT).show();





        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Uri contentUri = getUriForFile(MainActivity.this,
                        getApplicationContext().getPackageName(), newFile);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                shareIntent.addFlags(FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                List<ResolveInfo> resInfoList = getApplicationContext().getPackageManager().queryIntentActivities(shareIntent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolveInfo : resInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    getApplicationContext().grantUriPermission(packageName, contentUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | FLAG_GRANT_READ_URI_PERMISSION);
                }
                setResult(RESULT_OK,shareIntent);





                startActivity(Intent.createChooser(shareIntent, "Share with"));

*/




            }
        });



    }

    public static InputStream getInputStreamFromUrl(String url) {
        InputStream content = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(url));
            content = response.getEntity().getContent();
        } catch (Exception e) {
            Log.e("[GET REQUEST]", "Network exception", e);
        }
        return content;
    }



}
