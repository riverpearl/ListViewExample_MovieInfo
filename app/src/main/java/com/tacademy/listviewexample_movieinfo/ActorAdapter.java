package com.tacademy.listviewexample_movieinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tacademy.listviewexample_movieinfo.data.Actor;
import com.tacademy.listviewexample_movieinfo.widget.ActorInfoView;
import com.tacademy.listviewexample_movieinfo.widget.CommentView;
import com.tacademy.listviewexample_movieinfo.widget.DramaView;
import com.tacademy.listviewexample_movieinfo.widget.MovieView;

import org.w3c.dom.Text;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class ActorAdapter extends BaseAdapter {

    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        if (actor != null) {
            this.actor = actor;
            notifyDataSetChanged();
        }
    }

    private static final int VIEW_TYPE_COUNT = 5;

    private static final int VIEW_TYPE_ACTOR_INFO = 0;
    private static final int VIEW_TYPE_CATEGORY_TITLE = 1;
    private static final int VIEW_TYPE_MOVIE = 2;
    private static final int VIEW_TYPE_DRAMA = 3;
    private static final int VIEW_TYPE_COMMENT = 4;

    @Override
    public int getCount() {
        if (actor == null) return 0;

        int cnt = 0;
        cnt++;

        if (actor.movies.size() > 0) cnt += (1 + actor.movies.size());
        if (actor.dramas.size() > 0) cnt += (1 + actor.dramas.size());
        if (actor.comments.size() > 0) cnt += (1 + actor.comments.size());

        return cnt;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return VIEW_TYPE_ACTOR_INFO;

        position--;

        if (actor.movies.size() > 0) {
            if (position == 0) return VIEW_TYPE_CATEGORY_TITLE;
            position--;
            if (position < actor.movies.size()) return VIEW_TYPE_MOVIE;
            position -= actor.movies.size();
        }

        if (actor.dramas.size() > 0) {
            if (position == 0) return VIEW_TYPE_CATEGORY_TITLE;
            position--;
            if (position < actor.dramas.size()) return VIEW_TYPE_DRAMA;
            position -= actor.dramas.size();
        }

        if (actor.comments.size() > 0) {
            if (position == 0) return VIEW_TYPE_CATEGORY_TITLE;
            position--;
            if (position < actor.comments.size()) return VIEW_TYPE_COMMENT;
            position -= actor.comments.size();
        }

        throw new IllegalArgumentException("Invalid Position");
    }

    @Override
    public Object getItem(int position) {
        if (position == 0) return actor;

        position--;

        if (actor.movies.size() > 0) {
            if (position == 0) return "Movie";
            position--;
            if (position < actor.movies.size()) return actor.movies.get(position);
            position -= actor.movies.size();
        }

        if (actor.dramas.size() > 0) {
            if (position == 0) return "Drama";
            position--;
            if (position < actor.dramas.size()) return actor.dramas.get(position);
            position -= actor.dramas.size();
        }

        if (actor.comments.size() > 0) {
            if (position == 0) return "Comment";
            position--;
            if (position < actor.comments.size()) return actor.comments.get(position);
            position -= actor.comments.size();
        }

        throw new IllegalArgumentException("Invalid Position");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 0) {
            ActorInfoView view;

            if (convertView != null || convertView instanceof ActorInfoView)
                view = (ActorInfoView)convertView;
            else view = new ActorInfoView(parent.getContext());

            view.setActor(actor);
            return view;
        }

        position--;

        if (actor.movies.size() > 0) {
            if (position == 0) {
                TextView view;

                if(convertView != null || convertView instanceof TextView)
                    view = (TextView)convertView;
                else view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

                view.setText("Movie");
                return view;
            }

            position--;

            if (position < actor.movies.size()) {
                MovieView view;

                if (convertView != null && convertView instanceof MovieView) {
                    view = (MovieView)convertView;
                } else {
                    view = new MovieView(parent.getContext());
                }

                view.setMovie(actor.movies.get(position));
                return view;
            }

            position -= actor.movies.size();
        }

        if (actor.dramas.size() > 0) {
            if (position == 0) {
                TextView view;

                if (convertView != null || convertView instanceof TextView)
                    view = (TextView)convertView;
                else view = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

                view.setText("Drama");
                return view;
            }

            position--;

            if (position < actor.dramas.size()) {
                DramaView view;

                if (convertView != null || convertView instanceof DramaView)
                    view = (DramaView)convertView;
                else view = new DramaView(parent.getContext());

                view.setDrama(actor.dramas.get(position));
                return view;
            }

            position -= actor.dramas.size();
        }

        if (actor.comments.size() > 0) {
            if (position == 0) {
                TextView view;

                if (convertView != null && convertView instanceof TextView)
                    view = (TextView)convertView;
                else view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

                view.setText("Comment");
                return view;
            }

            position--;

            if (position < actor.comments.size()) {
                CommentView view;

                if (convertView != null && convertView instanceof CommentView)
                    view = (CommentView)convertView;
                else view = new CommentView(parent.getContext());

                view.setComment(actor.comments.get(position));
                return view;
            }

            position -= actor.comments.size();
        }

        throw new IllegalArgumentException("Invalid Position");
    }
}
