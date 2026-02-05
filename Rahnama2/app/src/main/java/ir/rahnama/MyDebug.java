package ir.rahnama;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ir.rahnama.R;

/**
 * Created by Mohammad on 9/20/2017.
 */

public class MyDebug {


    public MyDebug(Context context, ArrayList<String> arrayList) {
        final Dialog mDialog;
        mDialog = new Dialog(context);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_my_debug);
        Button ok;
        TextView message;
        message = (TextView) mDialog.findViewById(R.id.dialogMessage);
        ok = (Button) mDialog.findViewById(R.id.dialogok);
        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                mDialog.cancel();

            }
        });


        String content = "";

        for (String s : arrayList) {
            content += s + "\n";
        }
        message.setText(content);


        mDialog.show();
    }

}
