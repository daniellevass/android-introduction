package danielle.dev.com.flickrviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocationsActivity extends ActionBarActivity {

    private ListView listLocations;
    private List<String> cities;
    private List<String> countries;
    private List<Integer> flags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        listLocations = (ListView)findViewById(R.id.listLocations);

        cities = new ArrayList<String>();

        cities.add("Hong Kong");
        cities.add("London");
        cities.add("San Francisco");
        cities.add("Madrid");
        cities.add("Sydney");
        cities.add("New York");
        cities.add("Bath");
        cities.add("Cardiff");
        cities.add("Dallas");


        countries = new ArrayList<String>();

        countries.add("China");
        countries.add("United Kingdom");
        countries.add("USA");
        countries.add("Spain");
        countries.add("Australia");
        countries.add("USA");
        countries.add("United Kingdon");
        countries.add("Wales");
        countries.add("USA");

        flags = new ArrayList<Integer>();

        flags.add(R.drawable.hongkong);
        flags.add(R.drawable.unitedkingdom);
        flags.add(R.drawable.unitedstates);
        flags.add(R.drawable.spain);
        flags.add(R.drawable.australia);
        flags.add(R.drawable.unitedstates);
        flags.add(R.drawable.unitedkingdom);
        flags.add(R.drawable.wales);
        flags.add(R.drawable.unitedstates);



        LocationAdapter adapter = new LocationAdapter(cities);

        listLocations.setAdapter(adapter);


    }



    private class LocationAdapter extends ArrayAdapter<String> {

        public LocationAdapter(List<String> items) {
            super(LocationsActivity.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.row_location, null);
            }
            ImageView imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
            TextView lblCity = (TextView)convertView.findViewById(R.id.lblCity);
            TextView lblCountry = (TextView)convertView.findViewById(R.id.lblCountry);

            String city = cities.get(position);
            String country = countries.get(position);
            int flag = flags.get(position);


            imgIcon.setImageResource(flag);
            lblCountry.setText(country);
            lblCity.setText(city);

            return convertView;
        }// end get view

    }// end adapter class



}
