package ir.infinty_json;

import android.view.View;

/**
 * Created by jefferson on 10/18/2017.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}