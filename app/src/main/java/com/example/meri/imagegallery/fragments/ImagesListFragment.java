package com.example.meri.imagegallery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meri.imagegallery.R;
import com.example.meri.imagegallery.adapters.RecyclerImageAdapter;

public class ImagesListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerImageAdapter mRecyclerImageAdapter;

    private RecyclerImageAdapter.OnItemClickListener mOnItemClickListener;

    public ImagesListFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        mRecyclerView = view.findViewById(R.id.image_recycler_view);
        mRecyclerImageAdapter = new RecyclerImageAdapter(getContext());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerImageAdapter);

        mRecyclerImageAdapter.setOnItemClickListener(mOnItemClickListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_images_list, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnItemClickListener = (RecyclerImageAdapter.OnItemClickListener)context;
        } catch (ClassCastException e){
            throw new ClassCastException("Not implemented");
        }
    }
}