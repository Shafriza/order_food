package org.shafriza.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardAdaptor cardAdaptor;
    private ArrayList<Card> cardArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        int intenVal = intent.getIntExtra("id", 1);

        switch (intenVal){

            case 1:
                getDataMakanan();
                break;
            case 2:
                getDataMinuman();
                break;
            case 3:
                getDataSnack();
                break;
            case 4:
                getDataDessert();
                break;

        }
        recyclerView = findViewById(R.id.recycleView);
        cardAdaptor = new CardAdaptor(this,cardArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardAdaptor);

    }

    public void getDataMakanan(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.steak,"Beef Steak","description1",23000));
        cardArrayList.add(new Card(R.drawable.nasgor,"Nasi Goreng","description1",23000));

    }

    public void getDataMinuman(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.egg_02,"title2","description2",50000));

    }
    public void getDataSnack(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.egg_02,"title3","description3",10000));

    }
    public void getDataDessert(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.egg_02,"title4","description4",30000));

    }
}