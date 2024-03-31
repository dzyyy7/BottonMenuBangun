package com.example.bangunmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public Adapter(List<Model> listData, Context context){
        this.listData = listData;
        this.mInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.bangun_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Model model = listData.get(position);
        holder.NamaBangun.setText(model.getNamaBangunn());
        holder.DeskBangun.setText(model.getDeskBangun());
        Glide.with(holder.itemView.getContext()).load(model.getImageBangun()).into(holder.ImageBangun);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView NamaBangun;
        TextView DeskBangun;
        ImageView ImageBangun;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            NamaBangun = itemView.findViewById(R.id.tvBangun);
            DeskBangun = itemView.findViewById(R.id.tvDeskBangun);
            ImageBangun = itemView.findViewById(R.id.ivBangun);
            itemView.setOnClickListener(this);
        }

        @Override
            public void onClick(View view) {
                if (mClickListener != null) mClickListener.onItemClick(view , getAdapterPosition());
        }
    }
    public Model getItem(int id) {
        return listData.get(id);
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

