package org.shafriza.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

      Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

    }
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);



        MenuItem searchIem = menu.findItem(R.id.search);
        MenuItem cart = menu.findItem(R.id.cart);

        cart.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent( Home.this, Cart.class);
                startActivity(intent);
                return false;
            }
        });


        final SearchView searchView = (SearchView) searchIem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                //Data akan berubah saat user menginputkan text/kata kunci pada SearchView
                nextText = nextText.toLowerCase();
                ArrayList<Card> dataFilter = new ArrayList<>();
                for (Card data : cardArrayList) {
                    String nama = data.getTitle().toLowerCase();
                    if (nama.contains(nextText)) {
                        dataFilter.add(data);
                    }
                }
                cardAdaptor.setFilter(dataFilter);

                return true;
            }
        });
        return true;
    }
    public void getDataMakanan(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.nasigoreng_01,"Nasi Goreng","Nasi goreng adalah sebuah makanan berupa nasi berbahasa latin oryza yang digoreng dan diaduk dalam minyak goreng atau margarin, biasanya ditambah kecap manis, bawang merah, bawang putih, " +
                "asam jawa, lada, dan bumbu-bumbu lainnya, seperti telur, ayam, dan kerupuk.",23000));
        cardArrayList.add(new Card(R.drawable.sotobabat_02,"Soto Babat","Soto babat adalah soto yang berbahan dasar dari bagian tubuh sapi, babat sapi adalah bagian jerohan dari sapi",23000));
        cardArrayList.add(new Card(R.drawable.satekambing_03,"Sate Kambing","Sate kambing adalah sejenis makanan sate terbuat dari daging kambing. Daging kambing tersebut disate (ditusuk dengan bambu yang dibentuk seperti lidi yang agak besar dan " +
                "dibumbui dengan rempah-rempah dan bumbu dapur, kemudian dibaka",23000));
        cardArrayList.add(new Card(R.drawable.ayamgeprek_04,"Ayam Geprek","ayam geprek merujuk pada hidangan berupa ayam goreng tepung garing yang diulek bersamaan dengan sambal. " +
                "Ayam geprek bisa dibilang hidangan cepat saji dengan cita rasa Indonesia",23000));
        cardArrayList.add(new Card(R.drawable.bebekgoreng_05,"Bebek Goreng","Bebek goreng adalah daging bebek yang dimasak dengan cara digoreng. Bebek goreng dapat ditemui di warung-warung kaki lima sampai di restoran dan hotel yang mewah",23000));
        cardArrayList.add(new Card(R.drawable.steakayam_06,"Steak Ayam","Chicken Steak adalah makanan yang terbuat dari daging ayam yang diolah menjadi steak dengan cara di beri bumbu khusus lalu di panggang selama ±1 jam",23000));
        cardArrayList.add(new Card(R.drawable.tunabakar_07,"Tuna Bakar","tuna Bakar merupakan masakan Indonesia dan negara Asia Tenggara lainnya, berupa sebuah hidangan ikan atau bentuk lain makanan laut yang dibakar menggunakan arang. Terkadang dibakar dengan dibungkus dengan daun pisang.",23000));
    }

    public void getDataMinuman(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.eslemon_01,"Lemon Tea","Lemon tea adalah teh yang menyegarkan dimana perasan lemon atau irisan lemon ditambahkan dalam teh.",50000));
        cardArrayList.add(new Card(R.drawable.bublegum_02,"Bubble Gum","Minuman yang enak dan kekinian yang memounyai rasa permen karet yang enak",50000));
        cardArrayList.add(new Card(R.drawable.lemon_03,"Lemon Squash","Minuman rasa lemon di padu dengan campuran soda",50000));
        cardArrayList.add(new Card(R.drawable.jeruk_04,"Orange Juice","Minuman jus jeruk yang banyak ada diluar bahkan diwarung-warung kecil dan sangat enak",50000));
        cardArrayList.add(new Card(R.drawable.cendool_05,"Cendol Durian","Es cendol adalah penganan yang dibuat dari tepung beras dan sebagainya yang dibentuk dengan penyaring, kemudian dicampur dengan air gula dantan dan durian",50000));
        cardArrayList.add(new Card(R.drawable.greentea_06,"GreenTea"," minuman green tea ala rumahan yang mudah dan enak dari komunitas memasak terbesar dunia! ",50000));
        cardArrayList.add(new Card(R.drawable.mangga10,"Manggo Jelly Ice","jelly mango ice ala rumahan yang mudah dan enak dari komunitas memasak terbesar dunia",50000));

    }
    public void getDataSnack(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.jamur01,"Jamur Crispy","Makanan dari jamur yang dibaluri dengan tepung dan digoreng secara merata dan dinikmati dengan sauce tomat",10000));
        cardArrayList.add(new Card(R.drawable.kentang02,"French Fries","Makanan dari kentang yang di iris dengan kentang yang diiris-iris berbentuk persegi panjang dan digoreng ",10000));
        cardArrayList.add(new Card(R.drawable.burger04,"Hamburger","Makanan yang berbahan baku daging roti slada dan lainya yang dipadukan dengan mayonaice dan sauce tomat yang enak",10000));
        cardArrayList.add(new Card(R.drawable.pisang01,"Pisang Coklat","Makanan dari pisang yang digoreng dan didalamnya ada coklat yang lumer dimulut",10000));
        cardArrayList.add(new Card(R.drawable.pancakage21,"Pancake Ice Cream","Pancake yang berpadu dengan dinginya ice cream yang enak",10000));
        cardArrayList.add(new Card(R.drawable.onion00,"Onion Rings","Makanan yang terbuat dari bawang bombay yang dilumuri tepung dan digoreng",10000));
        cardArrayList.add(new Card(R.drawable.sosis10,"Sosis Bakar","Makanan yang terbuat dari sosis yang dibakar",10000));

    }
    public void getDataDessert(){
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(R.drawable.desert01,"Dessert Oreo Lumer","Dessert yang berbahan utama dari oreo yang lumer",30000));
        cardArrayList.add(new Card(R.drawable.blackbery02,"Blackbery Summer Pudding","Pudding yang berbahan baku dari blackberry",30000));
        cardArrayList.add(new Card(R.drawable.strawbery03,"Strawberry Cheesecake","Chesscake yang terbuat dari bahan baku strawberry",30000));
        cardArrayList.add(new Card(R.drawable.lemon05,"Zesty Lemon Squares","Pudding desert enak yang berbahan baku lemon",30000));
        cardArrayList.add(new Card(R.drawable.puding07,"Pudding Melon","puding melon ala rumahan yang mudah dan enak dari komunitas memasak terbesar dunia",30000));
        cardArrayList.add(new Card(R.drawable.durian08,"Pancake Durian","Pancake durian adalah kue yang berisi daging durian ditambah vla kemudian diselimuti kulit pancake yang lembut",30000));
        cardArrayList.add(new Card(R.drawable.manggo11,"Manggo Sago","Mango Sago adalah dessert dari fresh Mango juice, dipadu dengan gurihnya coconut milk, tapioca pearl / sagu mutiara, irisan buah mangga segar",30000));
    }


}