package ir.farsibase;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        RadioGroup rg =(RadioGroup)findViewById(R.id.psd);
        final String [] priorty = {"1","2","2","4","5","6","7","8","9"};
        final String [] array = getResources().getStringArray(R.array.F2S22_1);

        int[] rb =new int []
                {
                        R.id.s6,
                        R.id.s7,
                        R.id.s8,
                        R.id.s9
                };

        RadioButton [] radioButtons = new RadioButton[priorty.length];





        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            }
        });
    }
}
