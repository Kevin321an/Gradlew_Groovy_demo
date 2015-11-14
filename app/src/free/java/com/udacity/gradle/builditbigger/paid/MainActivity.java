package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.asyncTask.AsyncTask_joke;

import www.fanfan.pub.mylibrary.ImageActivity;



public class MainActivity extends ActionBarActivity implements  com.udacity.gradle.builditbigger.asyncTask.AsyncTask_joke.mAsyncTaskListener{

    private String joke;
    final public String KEY_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView)findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        new AsyncTask_joke(this).execute();
    }

    @Override
    public void toResult(Object message) {
        joke=(String)message;
    }

    public void tellJokeButton(View view) {
        Intent myIntent = new Intent(this, ImageActivity.class);

        //wrap the joke into the intent then delivery to other class
        myIntent.putExtra(KEY_JOKE, joke);
        startActivity(myIntent);
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }



}

