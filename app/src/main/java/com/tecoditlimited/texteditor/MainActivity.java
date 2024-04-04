package com.tecoditlimited.texteditor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jp.wasabeef.richeditor.RichEditor;

public class MainActivity extends AppCompatActivity {

    private RichEditor rich_editor;
    private RecyclerView recyclerView;
    IconRecyclerviewAdapter iconRecyclerviewAdapter;

    private int [] icon = {R.drawable.ic_bold, R.drawable.ic_bold,R.drawable.ic_align_left,R.drawable.ic_align_center,R.drawable.ic_align_right,R.drawable.ic_undo,R.drawable.ic_redo,R.drawable.ic_font_size,R.drawable.ic_background_colors,R.drawable.ic_font_family};
    private String [] text = {"Bold","Italic"," Justify Left","Justify Center", "Justify Right","Undo","Redo","Font Size","Background Color","Font Family"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        iconRecyclerviewAdapter =new IconRecyclerviewAdapter(MainActivity.this,text,icon);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(iconRecyclerviewAdapter);

        //to introduce
        rich_editor = findViewById(R.id.rich_editor);
        recyclerView = findViewById(R.id.recyclerView);
        iconRecyclerviewAdapter = new IconRecyclerviewAdapter(this,text,icon);

        // You can now manipulate the RichEditor
        rich_editor.setEditorHeight(200);
        rich_editor.setEditorFontSize(22);



        rich_editor.setPadding(10, 10, 10, 10);
        // More customization options are available, check the library documentation for details

        rich_editor.setPlaceholder("Insert text here...");




    }//-------onCreate end here  --------------------------------------------------------------

}