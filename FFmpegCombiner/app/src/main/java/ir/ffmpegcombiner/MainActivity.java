package ir.ffmpegcombiner;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.coremedia.iso.boxes.Container;
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shpr;
    SharedPreferences sh;
    FFmpeg ffmpeg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAPTURE_AUDIO_OUTPUT, Manifest.permission.RECORD_AUDIO};
        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

        String filepath_1 = Environment.getExternalStorageDirectory().getPath();
        File files = new File(filepath_1,"AudioRecorder");

        if(!files.exists()){
            files.mkdirs();
        }
        shpr = getApplicationContext().getSharedPreferences("record", 0);
        final SharedPreferences.Editor editor = shpr.edit();
        if(!shpr.contains("start_record")) {
            editor.putBoolean("start_record", false);
            editor.commit();
        }

        sh = getSharedPreferences("record", 0);
        if (!(sh.getBoolean("start_record",false)))
        {
            ffmpeg = FFmpeg.getInstance(this);
            try {
                ffmpeg.loadBinary(new LoadBinaryResponseHandler() {

                    @Override
                    public void onStart() {
                        Toast.makeText(MainActivity.this, "start copy data", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "failed !", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "finish", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (FFmpegNotSupportedException e) {
            }
        }

        final TextView tv = (TextView)findViewById(R.id.tv);

        String filepath ="/mnt/sdcard/AudioRecorder/list.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filepath);
            byte[] buffer = "file '/storage/emulated/0/AudioRecorder/1.mp4'\nfile '/storage/emulated/0/AudioRecorder/1.mp4'\nfile '/storage/emulated/0/AudioRecorder/1.mp4'".getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        final String[] ffmpegCommand = new String[]{  /*its working but not concat recorded file*/
                "-y",
                "-i",
                "concat:"+"/storage/emulated/0/AudioRecorder/1.mp4" + "|" +"/storage/emulated/0/AudioRecorder/1.mp4"+ "|" + "/storage/emulated/0/AudioRecorder/1.mp4",
                "-c",
                "copy",
                Environment.getExternalStorageDirectory().getPath()+"/AudioRecorder/result.mp4"};



       String[] cmd = new String[]{"-f","concat", "-safe","0", "-i",Environment.getExternalStorageDirectory().getPath()+"/AudioRecorder/list.txt","-c" ,"copy", "-preset", "ultrafast", Environment.getExternalStorageDirectory().getPath()+"/AudioRecorder/result.mp4"};


        try {
            ffmpeg.execute(ffmpegCommand, new ExecuteBinaryResponseHandler() {
                @Override
                public void onFailure(String s) {
                    Toast.makeText(MainActivity.this, "falied +"+s, Toast.LENGTH_LONG).show();
                    tv.setText(s.toString());
                }

                @Override
                public void onSuccess(String s) {
                    Toast.makeText(MainActivity.this, "succes +", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onProgress(String s) {
                    Toast.makeText(MainActivity.this, "progress", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStart() {
                    Toast.makeText(MainActivity.this, "startted !!!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFinish() {
                    Toast.makeText(MainActivity.this, "work finieshed !", Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (FFmpegCommandAlreadyRunningException e) {
            e.printStackTrace();
        }

    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
