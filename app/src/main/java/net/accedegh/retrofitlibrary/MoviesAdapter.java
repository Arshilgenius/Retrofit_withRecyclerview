package net.accedegh.retrofitlibrary;

/**
 * Created by frank on 12/16/16.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by frank on 12/13/16.
 */


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<net.accedegh.retrofitlibrary.Movie> movies;
    private Context context;

    public MoviesAdapter(Context applicationContext, List<net.accedegh.retrofitlibrary.Movie> movieArrayList) {
        this.context =applicationContext;
        this.movies=movieArrayList;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(movies.get(i).getName());
        viewHolder.actors.setText(movies.get(i).getDescription());

        // This is how we use Picasso to load images from the internet.
//       Picasso.with(context)
//                .load(movies.get(i).ge())
//                .placeholder(R.drawable.load)
//               .into(viewHolder.imageView);

        //viewHolder.imageView.setImageURI(movies.get(i).getCover());
    }

    @Override
    public int getItemCount() {
        if (movies == null)
            return 0;
        else
            return  movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, year, actors;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.year);
            actors = (TextView) view.findViewById(R.id.actors);
            imageView= (ImageView) view.findViewById(R.id.cover);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        net.accedegh.retrofitlibrary.Movie clickedDataItem = movies.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("movie_title", movies.get(pos).getName());
                        intent.putExtra("movie_actors", movies.get(pos).getDescription());
                        intent.putExtra("movie_year", movies.get(pos).getFork());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        }

    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }


    public void addAll(int position, List<net.accedegh.retrofitlibrary.Movie> mov) {
        movies.addAll(0,mov);
        notifyItemInserted(0);
        notifyDataSetChanged();
    }
}