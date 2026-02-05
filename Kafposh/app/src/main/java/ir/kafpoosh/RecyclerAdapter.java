package ir.kafpoosh;

/**
 * Created by jefferson on 10/18/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    Context _context;
    List<Product> list;
//    private ArrayList<RecyclerModel> recyclerModels = new ArrayList<RecyclerModel>();

    public RecyclerAdapter(List<Product> list,Context context) {
        this.list = list;
        this._context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = list.get(position);

        holder.title.setText(product.getTitle());
        holder.model.setText(product.getModel());
        Picasso.with(_context).load(product.getImageUrl()).fit().centerCrop().into(holder.image);
//        imageLoader.displayImage(product.getImageUrl(), holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, model;
        ImageView image;

        MyViewHolder(View view) {
            super(view);

            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            model = (TextView) itemView.findViewById(R.id.model);
        }
    }
}