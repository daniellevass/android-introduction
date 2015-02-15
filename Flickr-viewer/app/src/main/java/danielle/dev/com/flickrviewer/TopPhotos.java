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

        /*
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
        */

        urls.add("https://farm3.staticflickr.com/2570/4093096412_2163a6e270_z.jpg?zz=1");
        urls.add("https://farm5.staticflickr.com/4007/4244993150_93f9fe3180_z.jpg");
        urls.add("https://farm3.staticflickr.com/2447/3671737557_6bffe3e901_z.jpg");
        urls.add("https://farm5.staticflickr.com/4030/4207122005_b28581efb0_z.jpg?zz=1");
        urls.add("https://farm8.staticflickr.com/7283/8713809821_ac665e7038_z.jpg");
        urls.add("https://farm3.staticflickr.com/2700/4322416621_4316cb0339_z.jpg");
        urls.add("https://farm8.staticflickr.com/7342/14129467036_142f71448b_z.jpg");
        urls.add("https://farm4.staticflickr.com/3053/2799565594_72a0a888c7_z.jpg");
        urls.add("https://farm1.staticflickr.com/199/503348013_8d8ad1e391_z.jpg");
        urls.add("https://farm5.staticflickr.com/4052/4267216622_8c4b46450c_z.jpg");

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


            //imgPhoto.setBackgroundColor(Color.parseColor(colour));

            Picasso.with(mContext).load(url).into(imgPhoto);

            return convertView;
        }


    }


}
