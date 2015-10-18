package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.asyncTask.AsyncTask_joke;


public class MainActivity extends ActionBarActivity implements  com.udacity.gradle.builditbigger.asyncTask.AsyncTask_joke.mAsyncTaskListener{

    private String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    /*public void tellJoke(View view){
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void toResult(Object message) {

        joke=(String)message;
    }

    public void tellJokeButton(View view) {

        //Jokes callJokeLibrary = new Jokes();
        //Toast.makeText(this, callJokeLibrary.thisNotAJoke(), Toast.LENGTH_SHORT).show();

        //Intent myIntent = new Intent(this, ImageActivity.class);
        //startActivity(myIntent);
        //new AsyncTask_joke().execute(new Pair<Context, String>(this, "Manfred"));
        new AsyncTask_joke(this).execute();


        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }



}
