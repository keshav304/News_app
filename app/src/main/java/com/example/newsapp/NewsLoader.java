package com.example.newsapp;

import android.content.Context;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

import static android.content.ContentValues.TAG;


public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        Log.i(TAG, "NewsLoader: "+ url);
        mUrl = url;
    }

    @Override
    public List<News> loadInBackground() {
        if(mUrl == null) return null;

        List<News> newsList = QueryUtils.fetchNewsData(mUrl);
        return newsList;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}