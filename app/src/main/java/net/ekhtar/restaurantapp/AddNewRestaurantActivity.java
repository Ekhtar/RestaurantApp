package net.ekhtar.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNewRestaurantActivity extends AppCompatActivity {

    private EditText etRestaurantName;
    private EditText etRestaurantPhoneNumber;
    private TextView tvRestaurantPlace;
    private Button addRestaurantBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etRestaurantName=(EditText)findViewById(R.id.etRestaurantName_AddRestaurant);
        etRestaurantPhoneNumber=(EditText)findViewById(R.id.etRestaurantPhoneNumber_AddRestaurant);
        tvRestaurantPlace=(TextView)findViewById(R.id.tvRestaurantPlace_AddRestaurant);
        addRestaurantBtn=(Button)findViewById(R.id.btnAddRestaurant_AddRestaurant);

        final DatabaseConnection connection=new DatabaseConnection(this);


        tvRestaurantPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                overridePendingTransition(0,0);
            }
        });

        addRestaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant restaurant=new Restaurant();
                restaurant.setName(etRestaurantName.getText().toString().trim());
                restaurant.setPhoneNumber(etRestaurantPhoneNumber.getText().toString().trim());
                connection.insertNewRestaurant(restaurant.getName(),restaurant.getPhoneNumber());
                Snackbar.make(v, "New Restaurant Added Successfully", Snackbar.LENGTH_LONG).show();;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(0,0);
    }

}
