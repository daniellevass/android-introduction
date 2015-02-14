package danielle.dev.com.flickrviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


    private List<CityLocation> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        listLocations = (ListView)findViewById(R.id.listLocations);

        locations = new ArrayList<CityLocation>();

        locations.add(new CityLocation("Hong Kong", "China", R.drawable.hongkong));
        locations.add(new CityLocation("Bath", "UK", R.drawable.unitedkingdom));
        locations.add(new CityLocation("San Francisco", "USA", R.drawable.unitedstates));
        locations.add(new CityLocation("Spain", "Spain", R.drawable.spain));
        locations.add(new CityLocation("Sydney", "Australia", R.drawable.australia));
        locations.add(new CityLocation("London", "United Kingdom", R.drawable.unitedkingdom));
        locations.add(new CityLocation("New York", "USA", R.drawable.unitedstates));



        //set up the adapter
        LocationAdapter adapter = new LocationAdapter(locations);

        //set the adapter to our listview
        listLocations.setAdapter(adapter);


    }


    private class LocationAdapter extends ArrayAdapter<CityLocation> {

        public LocationAdapter(List<CityLocation> items) {
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

            //get the location
            CityLocation location = locations.get(position);

            //set the ui elements to the location
            imgIcon.setImageResource(location.getFlag());
            lblCountry.setText(location.getCountry());
            lblCity.setText(location.getCity());

            return convertView;
        }// end get view

    }// end adapter class



}
