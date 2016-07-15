package com.tacademy.listviewexample_movieinfo.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tacademy.listviewexample_movieinfo.R;
import com.tacademy.listviewexample_movieinfo.data.Drama;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class DramaView extends FrameLayout {

    public DramaView(Context context) {
        super(context);
        init();
    }

    ImageView pictureView;
    TextView titleView, intervalView;

    private void init() {
        inflate(getContext(), R.layout.view_drama, this);
        pictureView = (ImageView)findViewById(R.id.image_picture);
        titleView = (TextView)findViewById(R.id.text_title);
        intervalView = (TextView)findViewById(R.id.text_interval);
    }

    private Drama drama;

    public Drama getDrama() {
        return drama;
    }

    public void setDrama(Drama drama) {
        this.drama = drama;
        pictureView.setImageDrawable(drama.picture);
        titleView.setText(drama.title);
        intervalView.setText(drama.interval);
    }
}
