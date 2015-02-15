package danielle.dev.com.flickrviewer;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TopPhotos extends ActionBarActivity {


    private GridView gridView;

    private List<String> colours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_photos);

        gridView = (GridView)findViewById(R.id.gridView);

        colours = new ArrayList<String>();

        colours.add("#ffcc00");
        colours.add("#F44336");
        colours.add("#E91E63");
        colours.add("#9C27B0");
        colours.add("#673AB7");
        colours.add("#3F51B5");
        colours.add("#2196F3");
        colours.add("#03A9F4");
        colours.add("#00BCD4");
        colours.add("#009688");
        colours.add("#4CAF50");
        colours.add("#8BC34A");
        colours.add("#CDDC39");
        colours.add("#FFEB3B");
        colours.add("#FFC107");
        colours.add("#FF9800");
        colours.add("#FF5722");

        TopImageAdapter adapter = new TopImageAdapter(TopPhotos.this);
        gridView.setAdapter(adapter);

    }



    private class TopImageAdapter extends BaseAdapter {
        private Context mContext;

        public TopImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return colours.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {


            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.cell_photo, null);
            }

            ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);

            String colour = colours.get(position);


            imgPhoto.setBackgroundColor(Color.parseColor(colour));
            return convertView;
        }


    }


}
