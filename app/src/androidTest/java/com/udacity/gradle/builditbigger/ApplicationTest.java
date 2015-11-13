package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.asyncTask.AsyncTask_joke;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> implements AsyncTask_joke.mAsyncTaskListener{
    public ApplicationTest() {
        super(Application.class);
    }


    private CountDownLatch signal;

    @UiThreadTest
    public void testAsyncTask() {
        signal = new CountDownLatch(1);
        AsyncTask_joke jokeAsyncTask = new AsyncTask_joke(this);
        jokeAsyncTask.execute();
        try {
        // block until the current count reaches zero due to invocations of the countDown() method
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toResult(Object o) {
        String res = (String)o;
        assertTrue(res != null);
        signal.countDown();
    }

}