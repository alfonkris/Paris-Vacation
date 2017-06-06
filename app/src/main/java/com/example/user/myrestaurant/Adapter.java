package com.example.user.myrestaurant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alfonkris on 05/06/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderCustom>{

    private Context context;
    private List<Info> listArray;

    public Adapter(Context context, List<Info> listArray){
        this.context=context;
        this.listArray=listArray;
    }

    @Override
    public ViewHolderCustom onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        ViewHolderCustom viewHolderCustom=new ViewHolderCustom(view);
        return viewHolderCustom;
    }

    @Override
    public void onBindViewHolder(ViewHolderCustom holder, int position) {
        Info info=listArray.get(position);
        holder.imageList.setImageResource(info.getImage());
        holder.textTitle.setText(info.getTitle());
        holder.textSubtitle.setText(info.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return listArray.size();
    }

    public void refill(Info info){
        listArray.add(info);
        notifyDataSetChanged();
    }

    class ViewHolderCustom extends RecyclerView.ViewHolder{
        ImageView imageList;
        TextView textTitle, textSubtitle;
        public ViewHolderCustom(View itemView) {
            super(itemView);

            imageList=(ImageView)itemView.findViewById(R.id.img_list);
            textTitle=(TextView)itemView.findViewById(R.id.tx_title);
            textSubtitle=(TextView)itemView.findViewById(R.id.tx_subtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Info info=listArray.get(getAdapterPosition());
                    Intent intent= new Intent(context, DetailActivity.class);
                    intent.putExtra("image", info.getImage());
                    intent.putExtra("title",info.getTitle());
                    intent.putExtra("description", info.getDescription());
                    intent.putExtra("location", info.getLocation());
                    context.startActivity(intent);
                }
            });
        }
    }
}
