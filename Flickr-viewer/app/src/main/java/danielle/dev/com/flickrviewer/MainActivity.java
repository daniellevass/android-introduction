package danielle.dev.com.flickrviewer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private Button btnLocations;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnLocations = (Button) findViewById(R.id.btnLocations);
        btnSearch = (Button) findViewById(R.id.btnSearch);


        btnLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked locations", Toast.LENGTH_SHORT ).show();

                Intent i = new Intent(MainActivity.this, LocationsActivity.class);
                startActivity(i);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked search", Toast.LENGTH_SHORT ).show();
                
                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });

    }

}
