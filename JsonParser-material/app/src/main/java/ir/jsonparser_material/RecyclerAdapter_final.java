package ir.jsonparser_material;

/**
 * Created by jefferson on 10/18/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class RecyclerAdapter_final extends RecyclerView.Adapter<RecyclerAdapter_final.MyViewHolder> {

    private ArrayList<RecyclerModel> recyclerModels; // this data structure carries our title and description

    public RecyclerAdapter_final(ArrayList<RecyclerModel> recyclerModels) {
        this.recyclerModels = recyclerModels;
    }

    @Override
    public RecyclerAdapter_final.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate your custom row layout here
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter_final.MyViewHolder holder, int position) {
        // update your data here

        holder.title.setText(recyclerModels.get(position).getTitle());
        holder.description.setText(recyclerModels.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return recyclerModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        // view this our custom row layout, so intialize your variables here
        private TextView title;
        private TextView description;

        MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);

        }
    }
}