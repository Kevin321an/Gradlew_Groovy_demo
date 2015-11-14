package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

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

