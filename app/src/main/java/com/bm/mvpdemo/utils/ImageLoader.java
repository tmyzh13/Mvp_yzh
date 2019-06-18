package com.bm.mvpdemo.utils;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bm.mvpdemo.R;
import com.bm.mvpdemo.glide.transformation.BlurTransformation;

public class ImageLoader {

    public static void image(ImageView imageView,String url){

        GlideHelper.with(imageView.getContext())
                .cache(true)
                .load(url)
                .into(imageView);
    }

    public static void banner(ImageView imageView,String url){
        GlideHelper.with(imageView.getContext())
                .cache(true)
                .load(url)
                .into(imageView);
    }

    public static void userIcon(ImageView imageView, String url){
        GlideHelper.with(imageView.getContext())
                .cache(true)
                .load(url)
                .into(imageView);
    }

    public static void userBlur(ImageView imageView,String url){
        if(TextUtils.isEmpty(url)){
            imageView.setImageResource(R.color.transparent);
            return;
        }
        GlideHelper.with(imageView.getContext())
                .cache(true)
                .load(url)
                .transformation(new BlurTransformation(0.2F))
                .into(imageView);
    }
    public static void userBlur(ImageView imageView, int res){
        GlideHelper.with(imageView.getContext())
                .cache(true)
                .load(res)
                .transformation(new BlurTransformation(0.2F))
                .into(imageView);
    }
}
