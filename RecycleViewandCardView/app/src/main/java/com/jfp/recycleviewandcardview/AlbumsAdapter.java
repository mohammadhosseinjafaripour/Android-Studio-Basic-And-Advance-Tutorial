package com.jfp.recycleviewandcardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by jefferson on 3/24/2017.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album>albumList;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card,parent,false);

        return new MyViewHolder(itemView);
    }
    public AlbumsAdapter(Context mContext,List<Album>albumList){
        this.mContext=mContext;
        this.albumList=albumList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Album album=albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumofsong()+"اهنگ ها");
        Glide.with(mContext).load(album.getThumbail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    public  void showpopupmenu(View view)
    {
        PopupMenu popup=new PopupMenu(mContext,view);
        MenuInflater inflater= popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album,popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,count;
        public ImageView thumbnail,overflow;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            count=(TextView)itemView.findViewById(R.id.count);
            thumbnail=(ImageView)itemView.findViewById(R.id.thumbnail);
            overflow=(ImageView)itemView.findViewById(R.id.overflow);


        }
    }
}
