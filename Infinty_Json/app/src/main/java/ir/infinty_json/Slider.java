package ir.infinty_json;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Slider extends AppCompatActivity {

    CarouselView carouselView;
    ImageLoader imageLoader;

    Bitmap bmp;

    //int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        imageLoader = ImageLoader.getInstance();

        final String url = "http://programchi.ir/wp-content/uploads/2017/04/logo.png";
        final DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(R.drawable.lock)
                .showImageOnFail(R.drawable.lock)
                .showImageOnLoading(R.drawable.lock).build();

         bmp = imageLoader.loadImageSync("http://programchi.ir/wp-content/uploads/2017/04/logo.png");

        imageView.setImageBitmap(bmp);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(1);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

               // imageLoader.displayImage(url, imageView, options);

            }
        });


    }


}
