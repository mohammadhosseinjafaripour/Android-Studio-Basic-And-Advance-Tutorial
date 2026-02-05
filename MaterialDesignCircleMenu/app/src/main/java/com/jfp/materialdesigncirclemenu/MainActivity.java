package com.jfp.materialdesigncirclemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleMenu circleMenu=(CircleMenu)findViewById(R.id.circleMenu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {

                switch (menuButton.getId())
                {
                    case R.id.alert:
                        showmessage("Alert");
                        break;
                    case R.id.edit:
                        showmessage("Edit");
                        break;
                    case R.id.place:
                        showmessage("Place");
                        break;
                    case R.id.favorite:
                        showmessage("Favorite");
                        break;
                    case R.id.search:
                        showmessage("Search");
                        break;
                }

            }
        });
    }
    private void showmessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
