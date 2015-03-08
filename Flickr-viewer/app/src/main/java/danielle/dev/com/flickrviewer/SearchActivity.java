package danielle.dev.com.flickrviewer;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SearchActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        View v = (View)findViewById(R.id.circle);


        v.getBackground().setColorFilter(Color.parseColor("#C62828"), PorterDuff.Mode.SRC_ATOP);


    }



}
