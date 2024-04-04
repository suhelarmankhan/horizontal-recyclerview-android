package com.tecoditlimited.texteditor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class IconRecyclerviewAdapter extends RecyclerView.Adapter<IconRecyclerviewAdapter.ViewHolder>{

    private Context context;
    private  String  [] text;
    private int [] icon;
    private int [] Actions;
    private AdapterView.OnItemClickListener onItemClickListener;
    public IconRecyclerviewAdapter(Context context, String[] text, int[] icon) {
        this.context = context;
        this.text = text;
        this.icon = icon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(icon[position]);
        holder.text.setText(text[position]);
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView icon;
            TextView text;
            LinearLayout iconLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            text = itemView.findViewById(R.id.text);
            iconLayout = itemView.findViewById(R.id.iconLayout);







//            boldLayout.setOnClickListener(v->{
//
//                rich_editor.setBold();
//
//            });
//
//            italicLayout.setOnClickListener(v->{
//                rich_editor.setItalic();
//            });

        }
    }
}
