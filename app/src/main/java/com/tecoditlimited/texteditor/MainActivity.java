package com.tecoditlimited.texteditor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.richeditor.RichEditor;

public class MainActivity extends AppCompatActivity {

    private RichEditor rich_editor;
    private RecyclerView recyclerView;
    public static List<Model> icon_text_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3,GridLayoutManager.HORIZONTAL,false));
        icon_text_list = new ArrayList<>();
        icon_text_list.add(new Model("Bold",R.drawable.ic_bold));
        icon_text_list.add(new Model("Italic",R.drawable.ic_italic));
        icon_text_list.add(new Model("Font Family",R.drawable.ic_font_family));
        icon_text_list.add(new Model("Justify Left",R.drawable.ic_align_left));
        icon_text_list.add(new Model("Justify Center",R.drawable.ic_align_center));
        icon_text_list.add(new Model("Justify Right",R.drawable.ic_align_right));
        icon_text_list.add(new Model("Undo",R.drawable.ic_undo));
        icon_text_list.add(new Model("Redo",R.drawable.ic_redo));
        icon_text_list.add(new Model("Font Size",R.drawable.ic_font_size));
        icon_text_list.add(new Model("Background Color",R.drawable.ic_background_colors));

        EditIconsAdapter Adapter =new EditIconsAdapter(icon_text_list);
        this.recyclerView.setAdapter(Adapter);

        //to introduce
        rich_editor = findViewById(R.id.rich_editor);
        recyclerView = findViewById(R.id.recyclerView);


        // You can now manipulate the RichEditor
        rich_editor.setEditorHeight(200);
        rich_editor.setEditorFontSize(22);



        rich_editor.setPadding(10, 10, 10, 10);
        // More customization options are available, check the library documentation for details

        rich_editor.setPlaceholder("Insert text here...");




    }//-------onCreate end here  --------------------------------------------------------------


    ///icons item adapter-----

    public static class EditIconsAdapter extends RecyclerView.Adapter<EditIconsAdapter.ViewHolder>{
        private final List<Model> icon_text_list;

        public EditIconsAdapter(List<Model> iconTextList) {
            icon_text_list = iconTextList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(this.icon_text_list.get(position));

        }

        @Override
        public int getItemCount() {
            return icon_text_list.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder{

            LinearLayout iconLayout;
            ImageView icon;
            TextView text;
          public   Model model;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                icon = itemView.findViewById(R.id.icon);
                iconLayout = itemView.findViewById(R.id.iconLayout);
                text = itemView.findViewById(R.id.text);



            }

            public void bind(Model model){
                this.model = model;
                this.text.setText(model.getText());
                this.icon.setImageResource(model.getIcon());
            }
        }
    }




}