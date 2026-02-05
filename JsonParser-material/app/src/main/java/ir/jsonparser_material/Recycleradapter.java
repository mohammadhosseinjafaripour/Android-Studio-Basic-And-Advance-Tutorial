package ir.jsonparser_material;

/**
 * Created by jefferson on 10/17/2017.
 */


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by JFP on 01-May-17.
 */

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.MyHolder> {

    List<Product> list;
    ImageLoader imageLoader;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public Recycleradapter(List<Product> list, ImageLoader imageLoader) {
        this.list = list;
        this.imageLoader = imageLoader;




    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final int pos = position;
        Product product = list.get(position);
        final  Product productfinal = list.get(position);
        holder.name.setText(product.getProductname());
        holder.color.setText(product.getColor());
        String image1 = product.getImageurl();
        imageLoader.displayImage(image1, holder.image);
        holder.price.setText("INR " + product.getPrice());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //MyHolder myHolder = new MyHolder(v);
                //int position = myHolder.getAdapterPosition();
                Toast.makeText(v.getContext(), ""+productfinal.getProductid(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(),Second_Activity.class);
                intent.putExtra("id",Integer.toString(productfinal.getProductid()));
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView name, color, price, productid;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.productimage);
            name = (TextView) itemView.findViewById(R.id.name);
            color = (TextView) itemView.findViewById(R.id.color);
            price = (TextView) itemView.findViewById(R.id.price);


        }
    }



}