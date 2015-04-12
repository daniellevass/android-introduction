package danielle.dev.com.flickrviewer;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SpecificLocationActivity extends ActionBarActivity {

    private TextView lblLocationTitle;

    private ViewGroup topLayout;
    private TextView lblMaxMin;
    private ImageView imgWeather;

    private TopLocationObject location;

    private List<FlickrSearchResponse.FlickrPhoto> photos;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_location);

        location = (TopLocationObject) getIntent().getSerializableExtra("EXTRA_TOP_LOCATION");


        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);
        topLayout = (ViewGroup)findViewById(R.id.topBar);
        lblMaxMin = (TextView)findViewById(R.id.lblMaxMin);
        imgWeather = (ImageView)findViewById(R.id.imgWeather);
        gridView = (GridView)findViewById(R.id.gridView);


        lblLocationTitle.setText(location.getCity());
        topLayout.setBackgroundColor(Color.parseColor(location.getColor()));
        imgWeather.setImageResource(location.getWeatherPicture());
        lblMaxMin.setText(location.getMinMax());

        getDataFromFlickr();


    }

    private void getDataFromFlickr()
    {
        Log.d("DANIELLE_FLICKR", "getting data");
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.flickr.com")
                .build();

        FlickrService service = restAdapter.create(FlickrService.class);

        String urlSafeTag;

        try
        {
            urlSafeTag = URLEncoder.encode(location.getCity(), "utf-8");
        }catch (Exception e)
        {
            urlSafeTag = "cats";
        }


        service.getSearchPhoto(urlSafeTag, new Callback<FlickrSearchResponse>() {
            @Override
            public void success(FlickrSearchResponse flickrSearchResponse, Response response) {

                Log.d("DANIELLE_FLICKR", "made it here" + response.getUrl());

                Log.d("DANIELLE_FLICKR", "made it here" + flickrSearchResponse.getPhotos().getPhoto().size());

                if (flickrSearchResponse.getPhotos().getPhoto() != null &&
                        flickrSearchResponse.getPhotos().getPhoto().size() > 0){

                    photos = flickrSearchResponse.getPhotos().getPhoto();

                    PhotoAdapter adapter = new PhotoAdapter(SpecificLocationActivity.this);
                    gridView.setAdapter(adapter);

                }

            }

            @Override
            public void failure(RetrofitError retrofitError) {

                Log.d("DANIELLE_FLICKR", retrofitError.getLocalizedMessage());

            }//end on failure
        }//end callbacks

        );//end get all hour request



    }




    private class PhotoAdapter extends BaseAdapter {
        private Context mContext;

        public PhotoAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return photos.size();
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

            FlickrSearchResponse.FlickrPhoto photo = photos.get(position);

            ImageView imgPicture = (ImageView)convertView.findViewById(R.id.imgPhoto);

            if (photo.getImageURL() != null && photo.getImageURL().length() > 0){
                Log.d("DANIELLE_FLICKR", photo.getImageURL());
                Picasso.with(mContext).load(photo.getImageURL()).into(imgPicture);
            } else {
                imgPicture.setBackgroundColor(Color.parseColor("#cc0000"));
            }


            return convertView;
        }//end get view


    }//end top image adapter





}
