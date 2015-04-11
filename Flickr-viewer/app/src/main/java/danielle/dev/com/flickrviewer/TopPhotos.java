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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopPhotos extends ActionBarActivity {


    private GridView gridView;

    private List<String> urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_photos);

        gridView = (GridView)findViewById(R.id.gridView);

        urls = new ArrayList<String>();

        urls.add("#ffcc00");
        urls.add("#F44336");
        urls.add("#E91E63");
        urls.add("#9C27B0");
        urls.add("#673AB7");
        urls.add("#3F51B5");
        urls.add("#2196F3");
        urls.add("#03A9F4");
        urls.add("#00BCD4");
        urls.add("#009688");
        urls.add("#4CAF50");
        urls.add("#8BC34A");
        urls.add("#CDDC39");
        urls.add("#FFEB3B");
        urls.add("#FFC107");
        urls.add("#FF9800");
        urls.add("#FF5722");


        TopImageAdapter adapter = new TopImageAdapter(TopPhotos.this);
        gridView.setAdapter(adapter);

    }



    private class TopImageAdapter extends BaseAdapter {
        private Context mContext;

        public TopImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return urls.size();
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

            String url = urls.get(position);

            imgPhoto.setBackgroundColor(Color.parseColor(url));

            return convertView;
        }//end get view


    }//end top image adapter


}
