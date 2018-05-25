package net.accedegh.retrofitlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import net.accedegh.retrofitlibrary.R;

public class DetailActivity extends AppCompatActivity {

    TextView Title,Year ,Plot, Directors, Actors;
    Toolbar mActionBarToolbar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageView = (ImageView) findViewById(R.id.movie_image_header);
        Actors= (TextView) findViewById(R.id.actors);
        Plot = (TextView) findViewById(R.id.plot);
        String title = getIntent().getExtras().getString("movie_title");
        String coverUrl =getIntent().getExtras().getString("movie_cover");
        String plot= getIntent().getExtras().getString("movie_plot");
        String actors = getIntent().getExtras().getString("movie_actors");


        Actors.setText(actors);
        Plot.setText(plot);
        Glide.with(this)
                .load(coverUrl)
                .placeholder(R.drawable.load)
                .into(imageView);

        getSupportActionBar().setTitle(title);
    }
}
