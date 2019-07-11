package com.codepath.instagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.instagram.model.Post;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class PostDetailActivity extends AppCompatActivity {

    Post post;
    ImageView ivUserProfile;
    TextView tvUserName;
    TextView tvDescription;
    TextView tvDate;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        ivUserProfile = (ImageView) findViewById(R.id.ivProfile);
        tvUserName = (TextView) findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivPostImage);
        tvDate = (TextView) findViewById(R.id.tvTimestamp);

        post = (Post) getIntent().getParcelableExtra(Post.class.getSimpleName());

        tvUserName.setText(post.getUser().getUsername());
        tvDescription.setText(post.getDescription());
        String date = post.getRelativeTimeAgo(post.getCreatedAt().toString());
        tvDate.setText(date);


//        Glide.with(this)
//                .load(post.getUser())
//                .bitmapTransform(new RoundedCornersTransformation(this, 100, 0))
//                .into(ivUserProfile);

        String mediaUrl = post.getImage().getUrl();
        Glide.with(this)
                .load(mediaUrl)
                .bitmapTransform(new RoundedCornersTransformation(this, 10, 0))
                .into(ivImage);
    }
}
