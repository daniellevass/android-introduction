package danielle.dev.com.flickrviewer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocationsActivity extends ActionBarActivity {

    private ListView listLocations;


<<<<<<< HEAD
    private List<TopLocationObject> topLocations;
=======
    private List<TopLocationObject> locations;
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        listLocations = (ListView)findViewById(R.id.listLocations);

<<<<<<< HEAD
        topLocations = new ArrayList<TopLocationObject>();

        topLocations.add(new TopLocationObject("Hong Kong", "China", R.drawable.hongkong));

        topLocations.add(new TopLocationObject("Bath", "UK", R.drawable.unitedkingdom));
        topLocations.add(new TopLocationObject("San Francisco", "USA", R.drawable.unitedstates));
        topLocations.add(new TopLocationObject("Spain", "Spain", R.drawable.spain));
        topLocations.add(new TopLocationObject("Sydney", "Australia", R.drawable.australia));
        topLocations.add(new TopLocationObject("London", "United Kingdom", R.drawable.unitedkingdom));
        topLocations.add(new TopLocationObject("New York", "USA", R.drawable.unitedstates));
=======
        locations = new ArrayList<TopLocationObject>();

        locations.add(new TopLocationObject("Hong Kong", "China", R.drawable.hongkong));
        locations.add(new TopLocationObject("Bath", "UK", R.drawable.unitedkingdom));
        locations.add(new TopLocationObject("San Francisco", "USA", R.drawable.unitedstates));
        locations.add(new TopLocationObject("Spain", "Spain", R.drawable.spain));
        locations.add(new TopLocationObject("Sydney", "Australia", R.drawable.australia));
        locations.add(new TopLocationObject("London", "United Kingdom", R.drawable.unitedkingdom));
        locations.add(new TopLocationObject("New York", "USA", R.drawable.unitedstates));
>>>>>>> origin/master



        //set up the adapter
        LocationAdapter adapter = new LocationAdapter(topLocations);

        //set the adapter to our listview
        listLocations.setAdapter(adapter);



<<<<<<< HEAD
=======
        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("FLICKR_TAG", "clicked on = " + position);

                Intent i = new Intent(LocationsActivity.this, SpecificLocationActivity.class);

                i.putExtra("EXTRA_TOP_LOCATION", locations.get(position));

                startActivity(i);

            }
        });


>>>>>>> origin/master
    }


    private class LocationAdapter extends ArrayAdapter<TopLocationObject> {

        public LocationAdapter(List<TopLocationObject> items) {
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
<<<<<<< HEAD
            TopLocationObject location = topLocations.get(position);
=======
            TopLocationObject location = locations.get(position);
>>>>>>> origin/master

            //set the ui elements to the location
            imgIcon.setImageResource(location.getFlagResource());
            lblCountry.setText(location.getCountryName());
            lblCity.setText(location.getCityName());

            return convertView;
        }// end get view

    }// end adapter class



}
