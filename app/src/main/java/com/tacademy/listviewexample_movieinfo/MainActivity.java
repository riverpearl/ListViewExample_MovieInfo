package com.tacademy.listviewexample_movieinfo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tacademy.listviewexample_movieinfo.data.Actor;
import com.tacademy.listviewexample_movieinfo.data.Comment;
import com.tacademy.listviewexample_movieinfo.data.Drama;
import com.tacademy.listviewexample_movieinfo.data.Movie;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ActorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_info);
        mAdapter = new ActorAdapter();
        listView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        Actor actor = new Actor();
        actor.photo = ContextCompat.getDrawable(this, R.drawable.sample_0);
        actor.name = "ysi";
        actor.age = 42;
        actor.description = "desc......";

        Movie movie = new Movie();
        movie.picture = ContextCompat.getDrawable(this, R.drawable.sample_1);
        movie.title = "movie title 1";
        movie.year = "2015";
        actor.movies.add(movie);

        movie = new Movie();
        movie.picture = ContextCompat.getDrawable(this, R.drawable.sample_2);
        movie.title = "movie title 2";
        movie.year = "2016";
        actor.movies.add(movie);

        movie = new Movie();
        movie.picture = ContextCompat.getDrawable(this, R.drawable.sample_3);
        movie.title = "movie title 3";
        movie.year = "2017";
        actor.movies.add(movie);

        Drama drama = new Drama();
        drama.picture = ContextCompat.getDrawable(this, R.drawable.sample_4);
        drama.title = "drama title 1";
        drama.interval = " 1  ~ 3";
        actor.dramas.add(drama);

        drama = new Drama();
        drama.picture = ContextCompat.getDrawable(this, R.drawable.sample_5);
        drama.title = "drama title 2";
        drama.interval = " 4  ~ 6";
        actor.dramas.add(drama);

        Comment comment = new Comment();
        comment.message = "comments .... 1";
        comment.writer = "writer 1";
        actor.comments.add(comment);

        comment = new Comment();
        comment.message = "comments .... 2";
        comment.writer = "writer 2";
        actor.comments.add(comment);

        mAdapter.setActor(actor);
    }
}
