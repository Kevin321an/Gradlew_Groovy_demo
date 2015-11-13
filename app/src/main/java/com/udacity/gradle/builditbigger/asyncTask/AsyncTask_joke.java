package com.udacity.gradle.builditbigger.asyncTask;

import android.os.AsyncTask;

import com.example.fm.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by FM on 10/17/2015.
 */
public class AsyncTask_joke extends AsyncTask<Void,Void, String> {

    private static MyApi myApiService = null;

    private final String URL = "https://build-it-bigger-1101.appspot.com/_ah/api/";

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(URL)
                    //.setRootUrl("https://built-it-bigger.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }


        try {
            String str= myApiService.thisNotAJoke().execute().getData();
            //String str=  myApiService.getJokes().execute().getData();
            return str;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private mAsyncTaskListener mSyncListener;

    public AsyncTask_joke(mAsyncTaskListener mSyncListener ) {
        super();
        //Initialization the mSyncListener when the new Object created
        this.mSyncListener=mSyncListener;

    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        mSyncListener.toResult(result);

    }

    public interface mAsyncTaskListener{
        void toResult(Object message);
    }


}
