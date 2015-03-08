package danielle.dev.com.flickrviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SpecificLocationActivity extends ActionBarActivity {

    private TextView lblLocationTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_location);

        TopLocationObject location = (TopLocationObject) getIntent().getSerializableExtra("EXTRA_TOP_LOCATION");


        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);

        lblLocationTitle.setText(location.getCity());

    }

}
