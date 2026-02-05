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


class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.MyViewHolder> {

    List<OrderHistory> list;

    public HistoryRecyclerAdapter(List<OrderHistory> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_custom_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrderHistory orderHistory = list.get(position);

        holder.model.setText("مدل: " + orderHistory.getModel());
        holder.dimension.setText("متراژ: " + orderHistory.getDimension()+" متر مربع");
        holder.status.setText("ID: " + orderHistory.getStatus());
        holder.id.setText(orderHistory.get_id());

        switch (orderHistory.get_id()) {
            case "waiting":
                holder.id.setText("درحال بررسی");
                break;
            case "accept":
                holder.id.setText("تایید شده");
                holder.id.setTextColor(Color.parseColor("#FF22E400"));
                break;
            case "cancel":
                holder.id.setTextColor(Color.parseColor("#FFFF0000"));
                holder.id.setText("لغو شده");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dimension, model, status, id;

        MyViewHolder(View view) {
            super(view);

            dimension = (TextView) itemView.findViewById(R.id.dimension);
            status = (TextView) itemView.findViewById(R.id.status);
            model = (TextView) itemView.findViewById(R.id.model);
            id = (TextView) itemView.findViewById(R.id.id);
        }
    }
}