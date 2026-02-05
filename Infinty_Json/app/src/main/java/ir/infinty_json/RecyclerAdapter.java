package ir.infinty_json;

/**
 * Created by jefferson on 10/18/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    ImageLoader imageLoader;
    List<Product> list;

    public RecyclerAdapter(List<Product> list,ImageLoader imageLoader) {
        this.list = list;
        this.imageLoader = imageLoader;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {


       // Product product = list.get(position);

        final int pos = position;
        Product product = list.get(position);
        final  Product productfinal = list.get(position);
        holder.name.setText(product.getProductname());
        holder.color.setText(product.getColor());
        String image1 = product.getImageurl();
        imageLoader.displayImage(image1, holder.image);
        holder.price.setText("INR " + product.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, color, price, productid;
        ImageView image;

        MyViewHolder(View view) {
            super(view);

            image = (ImageView) itemView.findViewById(R.id.productimage);
            name = (TextView) itemView.findViewById(R.id.name);
            color = (TextView) itemView.findViewById(R.id.color);
            price = (TextView) itemView.findViewById(R.id.price);

        }
    }
}