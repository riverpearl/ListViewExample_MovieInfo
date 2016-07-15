package com.tacademy.listviewexample_movieinfo.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tacademy.listviewexample_movieinfo.R;
import com.tacademy.listviewexample_movieinfo.data.Movie;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class MovieView extends FrameLayout {

    public MovieView(Context context) {
        super(context);
        init();
    }

    ImageView pictureView;
    TextView titleView, yearView;

    private void init() {
        inflate(getContext(), R.layout.view_movie, this);
        pictureView = (ImageView)findViewById(R.id.image_picture);
        titleView = (TextView)findViewById(R.id.text_title);
        yearView = (TextView)findViewById(R.id.text_year);
    }

    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        pictureView.setImageDrawable(movie.picture);
        titleView.setText(movie.title);
        yearView.setText(movie.year);
    }
}
