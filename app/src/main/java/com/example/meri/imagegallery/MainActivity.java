package com.example.meri.imagegallery;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meri.imagegallery.adapters.RecyclerImageAdapter;
import com.example.meri.imagegallery.fragments.ImageViewPagerFragment;
import com.example.meri.imagegallery.fragments.ImagesListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        RecyclerImageAdapter.OnItemClickListener{

    private final String IMAGES = "Images";
    private final String POSITION = "Position";

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagesListFragment imagesListFragment = new ImagesListFragment();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.frame, imagesListFragment, "ImageList");
        mFragmentTransaction.commit();
    }

    @Override
    public void onImageClick(ArrayList<String> images, int position) {
        Bundle args = new Bundle();
        args.putStringArrayList(IMAGES, images);
        args.putInt(POSITION, position);

        ImageViewPagerFragment imageViewPagerFragment = new ImageViewPagerFragment();
        imageViewPagerFragment.setArguments(args);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, imageViewPagerFragment, "ImagePager");
        mFragmentTransaction.addToBackStack("ImagePager");
        mFragmentTransaction.commit();
    }
}
