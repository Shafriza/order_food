package org.shafriza.miniproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CardView cd1,cd2,cd3,cd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//start of mengambil nilai pada masing masing cardd
        cd1 = findViewById(R.id.card_food);
        cd1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent home = new Intent(MainActivity.this, Home.class);
                home.putExtra("id",1);
                startActivity(home);
            }
        });

        cd2 = findViewById(R.id.card_drink);
        cd2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent home = new Intent(MainActivity.this, Home.class);
                home.putExtra("id",2);
                startActivity(home);
            }
        });

        cd3 = findViewById(R.id.card_snack);
        cd3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent home = new Intent(MainActivity.this, Home.class);
                home.putExtra("id",3);
                startActivity(home);
            }
        });

        cd4 = findViewById(R.id.card_desert);
        cd4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent home = new Intent(MainActivity.this, Home.class);
                home.putExtra("id",4);
                startActivity(home);
            }
        });
//end of card



    }

}