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



    private List<TopLocationObject> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        listLocations = (ListView)findViewById(R.id.listLocations);

        locations = new ArrayList<TopLocationObject>();

        locations.add(new TopLocationObject("Hong Kong", "China", R.drawable.hongkong, "#CC0000", R.drawable.w_foggy_night, 18, 26));
        locations.add(new TopLocationObject("Bath", "UK", R.drawable.unitedkingdom, "#212121", R.drawable.w_sunny, 0, 0));
        locations.add(new TopLocationObject("San Francisco", "USA", R.drawable.unitedstates, "#6A1B9A", R.drawable.w_sunny, 8, 19));
        locations.add(new TopLocationObject("Spain", "Spain", R.drawable.spain, "#212121", R.drawable.w_sunny, 0, 0));
        locations.add(new TopLocationObject("Sydney", "Australia", R.drawable.australia, "#212121", R.drawable.w_sunny, 0, 0));
        locations.add(new TopLocationObject("London", "United Kingdom", R.drawable.unitedkingdom, "#212121", R.drawable.w_sunny, 0, 0));
        locations.add(new TopLocationObject("New York", "USA", R.drawable.unitedstates, "#212121", R.drawable.w_sunny, 0, 0));




        //set up the adapter
        LocationAdapter adapter = new LocationAdapter(locations);

        //set the adapter to our listview
        listLocations.setAdapter(adapter);


        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("FLICKR_TAG", "clicked on = " + position);

                Intent i = new Intent(LocationsActivity.this, SpecificLocationActivity.class);

                i.putExtra("EXTRA_TOP_LOCATION", locations.get(position));

                startActivity(i);

            }
        });

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
            TopLocationObject location = locations.get(position);


            //set the ui elements to the location
            imgIcon.setImageResource(location.getFlag());
            lblCountry.setText(location.getCountry());
            lblCity.setText(location.getCity());

            return convertView;
        }// end get view

    }// end adapter class



}
