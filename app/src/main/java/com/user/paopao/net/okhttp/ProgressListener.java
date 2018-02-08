package com.user.paopao.net.okhttp;

public interface ProgressListener {

    void onProgress(long progress, long total, boolean done);
}
