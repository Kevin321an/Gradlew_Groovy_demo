package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void toResult(Object message) {

        joke=(String)message;
    }

    public void tellJokeButton(View view) {
        Intent myIntent = new Intent(this, ImageActivity.class);

        //wrap the joke into the intent then delivery to other class
        myIntent.putExtra(KEY_JOKE,joke);
        startActivity(myIntent);

        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }



}
