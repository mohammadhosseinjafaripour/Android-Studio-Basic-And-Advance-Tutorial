package ir.kafpoosh;

/**
 * Created by jefferson on 10/18/2017.
 */

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


class RequestRecyclerAdapter extends RecyclerView.Adapter<RequestRecyclerAdapter.MyViewHolder> {

    List<RequestHistory> list;

    public RequestRecyclerAdapter(List<RequestHistory> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_request, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RequestHistory orderHistory = list.get(position);

        holder.model.setText("مدل: " + orderHistory.getModel());
        holder.id.setText("ID: " + orderHistory.get_id());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dimension, model, status, id;

        MyViewHolder(View view) {
            super(view);
            model = (TextView) itemView.findViewById(R.id.model);
            id = (TextView) itemView.findViewById(R.id.id);
        }
    }
}