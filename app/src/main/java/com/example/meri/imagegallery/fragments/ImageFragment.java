package com.example.meri.imagegallery.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.meri.imagegallery.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageFragment extends Fragment {

    private ImageView mImageView;

    private ArrayList<String> mImages;
    private int mPosition;


    public ImageFragment() {
    }

    public void setFields(ArrayList<String> images, int position){
        mImages = images;
        mPosition = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image, container, false);

        mImageView = view.findViewById(R.id.image_item);
        Picasso.with(getContext()).load(Uri.parse(mImages.get(mPosition))).into(mImageView);

        return view;
    }

}
