package com.bm.mvpdemo.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import io.reactivex.disposables.Disposable;

/**
 * 用来控制Observable 与Observer之间控制通道的关闭
 * Created by issuser on 2018/3/26.
 */

public class RxActionManagerImpl implements RxActionManager {

    private static RxActionManagerImpl instance;
    //Disposable是控制通道
    private ArrayMap<String,Disposable> maps;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private RxActionManagerImpl(){
        maps =new ArrayMap<>();
    }

    public static RxActionManagerImpl getInstance(){
        if(instance==null){
          instance=new RxActionManagerImpl();
        }
        return instance;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void add(String tag, Disposable disposable) {
        maps.put(tag,disposable);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void remove(String tag) {
        if(!maps.isEmpty()){
            if(maps.get(tag)!=null){
                maps.remove(tag);
            }
        }

    }

    @Override
    public void cancel(String tag) {
        if(!maps.isEmpty()){
            if(maps.get(tag)!=null){
               if(!maps.get(tag).isDisposed()){
                   maps.get(tag).dispose();
                   maps.remove(tag);
               }
            }
        }
    }
    /**
     * 判断是否取消了请求
     *
     * @param tag
     * @return
     */
    public boolean isDisposed(String tag) {
        if (maps.isEmpty() || maps.get(tag) == null) return true;
        return maps.get(tag).isDisposed();
    }
}
