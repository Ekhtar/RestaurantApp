package net.ekhtar.restaurantapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hossam Magdy on 12/6/2017.
 */

public class RestaurantAdaptor extends BaseAdapter {
    private Context context;
    private ArrayList<Restaurant> restaurantList;

    public RestaurantAdaptor(Context context, ArrayList<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @Override
    public int getCount() {
        return restaurantList.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return restaurantList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context,R.layout.restaurant_item,null);
        TextView name=(TextView)view.findViewById(R.id.tvName_Item);
        TextView phoneNumber=(TextView)view.findViewById(R.id.tvPhoneNumber_Item);

        Restaurant restaurant=restaurantList.get(position);
        name.setText(restaurant.getName());
        phoneNumber.setText(restaurant.getPhoneNumber());
        return view;
    }
}
