package com.bm.mvpdemo.glide;

import android.support.annotation.WorkerThread;

public interface OnProgressListener {
    @WorkerThread
    void onProgress(float progress);
}
