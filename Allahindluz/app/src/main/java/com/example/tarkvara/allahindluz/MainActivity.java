package com.example.tarkvara.allahindluz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.tarkvara.allahindluz.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    GridView itemGrid;

    ArrayList<Product> gridArray = new ArrayList<Product>();
    ArrayList<Product> gridFilterArray = new ArrayList<Product>();

    MyAdapter adapter;

    Boolean isHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridArray.add(new Product("Hele ploom", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Pirn", 8.3, 5.2, "ÜKS"));
        gridArray.add(new Product("Banaan", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Tume ploom", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Sukapüksid", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Piim", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Jogurt", 243, 2.2, "ÜKS"));
        gridArray.add(new Product("Joogijogurt", 12.3, 6.2, "ÜKS"));
        gridArray.add(new Product("Müsli", 5.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Ajakiri 'Jalka'", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Sai", 243, 2.2, "ÜKS"));
        gridArray.add(new Product("Leib", 12.3, 6.2, "ÜKS"));
        gridArray.add(new Product("Hambapasta", 5.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Hambahari", 23.3, 2.2, "ÜKS"));
        gridArray.add(new Product("Shokolaad", 243, 2.2, "ÜKS"));
        gridArray.add(new Product("Shokolaadikommid", 12.3, 6.2, "ÜKS"));
        gridArray.add(new Product("Piimashokolaad", 5.3, 2.2, "ÜKS"));

        gridFilterArray.addAll(gridArray);

        itemGrid = (GridView) findViewById(R.id.itemGrid);
        adapter = new MyAdapter(this, R.layout.griditem, gridFilterArray);
        itemGrid.setAdapter(adapter);


        final EditText i = (EditText) findViewById(R.id.searchBar);
        i.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                gridFilterArray.clear();
                for (Product p : gridArray) {
                    if (p.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                        gridFilterArray.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final Button b = (Button) findViewById(R.id.shop_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHidden) {
                    for (Product p : gridArray) {
                        if (p.getName().toLowerCase().contains(i.getText().toString().toLowerCase())) {
                            gridFilterArray.add(p);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    b.setText("POOD ÜKS \u25B2");
                    isHidden = false;
                } else {
                    gridFilterArray.clear();
                    adapter.notifyDataSetChanged();
                    b.setText("POOD ÜKS \u25BC");
                    isHidden = true;
                }

            }
        });



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        else if(id == R.id.action_drawer){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all) {
            // Handle the camera action
        } else if (id == R.id.nav_cat) {

        } else if (id == R.id.nav_best) {


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
