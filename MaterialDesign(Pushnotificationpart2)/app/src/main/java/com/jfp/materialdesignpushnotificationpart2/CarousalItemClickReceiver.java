package com.jfp.materialdesignpushnotificationpart2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import in.mamga.carousalnotification.Carousal;
import in.mamga.carousalnotification.CarousalItem;

/**
 * Created by jefferson on 3/28/2017.
 */

public class CarousalItemClickReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            CarousalItem item = bundle.getParcelable(Carousal.CAROUSAL_ITEM_CLICKED_KEY);
            if (item != null) {
                String id = item.getId();
                switch (id)
                {
                    case "1":
                    {
                        Toast.makeText(context, ""+id, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case "2":
                    {
                        Toast.makeText(context, ""+id, Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case "3":
                    {
                        Toast.makeText(context, ""+id, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case "4":
                    {
                        Toast.makeText(context, ""+id, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:
                        Toast.makeText(context, "Lol", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Other region clicked", Toast.LENGTH_LONG).show();
            }

        }
    }
}