package com.example.meri.imagegallery.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.meri.imagegallery.R;

public class ImageViewHolder extends RecyclerView.ViewHolder{

    private ImageView mImageView;

    public ImageViewHolder(View view){
        super(view);

        mImageView = view.findViewById(R.id.image);
    }

    public ImageView getImageView() {
        return mImageView;
    }
}
