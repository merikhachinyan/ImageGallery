package com.example.meri.imagegallery.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.meri.imagegallery.R;
import com.example.meri.imagegallery.adapters.ImagePagerAdapter;

import java.util.ArrayList;

public class ImageViewPagerFragment extends Fragment {

    private final String IMAGES = "Images";
    private final String POSITION = "Position";

    private ArrayList<String> mImages = new ArrayList<>();
    private ImageView[] mImageDots;

    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;

    public ImageViewPagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image_view_pager,
                container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int selectedPosition = 0;

        if (getArguments() != null) {
            mImages = getArguments().getStringArrayList(IMAGES);
            selectedPosition = getArguments().getInt(POSITION);
        }

        mViewPager = view.findViewById(R.id.view_pager);
        mLinearLayout =view.findViewById(R.id.layout_dots);

        final ImagePagerAdapter imagePagerAdapter = new
                ImagePagerAdapter(getChildFragmentManager(), mImages);

        mViewPager.setAdapter(imagePagerAdapter);
        mViewPager.setCurrentItem(selectedPosition);

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(55, 0, 55, 0);
        mViewPager.setPageMargin(24);

//        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//            }
//        });

        final int dotsCount;

        if(imagePagerAdapter.getCount() > 5){
            dotsCount = 5;
        } else {
            dotsCount = imagePagerAdapter.getCount();
        }

        mImageDots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++){

            mImageDots[i] = new ImageView(getContext());

            mImageDots[i].setImageDrawable(ContextCompat
                    .getDrawable(getContext(), R.drawable.unselected_item));

            LinearLayout.LayoutParams layoutParams = new
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(6, 0, 6, 0);
            mLinearLayout.addView(mImageDots[i], layoutParams);
        }

        if(imagePagerAdapter.getCount() < 5){
            mImageDots[selectedPosition].setImageDrawable(ContextCompat
                    .getDrawable(getContext(), R.drawable.selected_item));
        } else {
            if (selectedPosition == imagePagerAdapter.getCount() - 1){
                mImageDots[dotsCount - 1].setImageDrawable(ContextCompat
                        .getDrawable(getContext(), R.drawable.selected_item));
            } else if(selectedPosition + 1 >= dotsCount){
                mImageDots[dotsCount - 2].setImageDrawable(ContextCompat
                        .getDrawable(getContext(), R.drawable.selected_item));
            } else {
                    mImageDots[selectedPosition].setImageDrawable(ContextCompat
                            .getDrawable(getContext(), R.drawable.selected_item));
            }
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (imagePagerAdapter.getCount() > 5) {
                    if (position < 4) {
                        for (int i = 0; i < dotsCount; i++) {
                            if (i != position) {
                                mImageDots[i].setImageDrawable(ContextCompat
                                        .getDrawable(getContext(), R.drawable.unselected_item));
                            } else {
                                mImageDots[i].setImageDrawable(ContextCompat
                                        .getDrawable(getContext(), R.drawable.selected_item));
                            }
                        }
                    } else {
                        if (position == 4) {
                            for (int i = 0; i < dotsCount; i++) {
                                if (i != dotsCount - 2) {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.unselected_item));
                                } else {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.selected_item));
                                }
                            }
                        } else if (position == imagePagerAdapter.getCount() - 1) {
                            for (int i = 0; i < dotsCount; i++) {
                                if (i != dotsCount - 1) {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.unselected_item));
                                } else {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.selected_item));
                                }
                            }
                        } else {
                            for (int i = 0; i < dotsCount; i++) {
                                if (i != dotsCount - 2) {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.unselected_item));
                                } else {
                                    mImageDots[i].setImageDrawable(ContextCompat
                                            .getDrawable(getContext(), R.drawable.selected_item));
                                }
                            }
                        }
                    }
                } else{
                    for (int i = 0; i < dotsCount; i++) {
                        if (i != position) {
                            mImageDots[i].setImageDrawable(ContextCompat
                                    .getDrawable(getContext(), R.drawable.unselected_item));
                        } else {
                            mImageDots[i].setImageDrawable(ContextCompat
                                    .getDrawable(getContext(), R.drawable.selected_item));
                        }
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
