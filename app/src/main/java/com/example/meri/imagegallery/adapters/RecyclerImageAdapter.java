package com.example.meri.imagegallery.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meri.imagegallery.R;
import com.example.meri.imagegallery.holder.ImageViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerImageAdapter extends RecyclerView.Adapter<ImageViewHolder>{

    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public RecyclerImageAdapter(Context context){
        mContext = context;
        addToList();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, final int position) {
        Picasso.with(mContext).load(Uri.parse(mImages.get(position))).into(holder.getImageView());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onImageClick(mImages, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    private void addToList(){
        mImages.add("https://www.teachermagazine.com.au/files/ce-image/cache/1c03ffc10fd4ef6a/Computing-programming-and-coding-in-schools_855_513_48.jpg");
        mImages.add("https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350");
        mImages.add("https://cdn.lynda.com/course/83603/83603-636216266356158373-16x9.jpg");
        mImages.add("https://cdn.pixabay.com/photo/2017/05/21/15/14/balloon-2331488_960_720.jpg");
        mImages.add("https://www.rencontres-arles.com/files/media_file_2106.jpg");
        mImages.add("http://www.technocrazed.com/wp-content/uploads/2015/01/Using-Arabic-Urdu-Persian-And-Other-Languages-Fonts-In-Android-App-Development-1.jpg");
        mImages.add("https://images.unsplash.com/photo-1508138142660-302e69e74271?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=723745f6e7639a75f8ca777830f1fa60&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb");
        mImages.add("http://fans-android.com/wp-content/uploads/2016/05/android.jpg");
    }

    public interface OnItemClickListener{
        void onImageClick(ArrayList<String> images, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
}
