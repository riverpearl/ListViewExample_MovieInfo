package com.tacademy.listviewexample_movieinfo.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tacademy.listviewexample_movieinfo.R;
import com.tacademy.listviewexample_movieinfo.data.Comment;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class CommentView extends FrameLayout {

    public CommentView(Context context) {
        super(context);
        init();
    }

    TextView messageView, writerView;

    private void init() {
        inflate(getContext(), R.layout.view_comment, this);
        messageView = (TextView)findViewById(R.id.text_message);
        writerView = (TextView)findViewById(R.id.text_writer);
    }

    private Comment comment;

    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
        messageView.setText(comment.message);
        writerView.setText(comment.writer);
    }
}
