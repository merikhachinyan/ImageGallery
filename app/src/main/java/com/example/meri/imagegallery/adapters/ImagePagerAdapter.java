package com.example.meri.imagegallery.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.meri.imagegallery.fragments.ImageFragment;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends FragmentPagerAdapter{

    private ArrayList<String> mImages = new ArrayList<>();

    ImageFragment mImageFragment;

    public ImagePagerAdapter(FragmentManager fm, ArrayList<String> images) {
        super(fm);

        setImages(images);
    }

    @Override
    public Fragment getItem(int position) {
        mImageFragment = new ImageFragment();
        mImageFragment.setFields(mImages, position);

        return mImageFragment;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    public void setImages(List<String> images){
        mImages.addAll(images);
    }
}
