package com.example.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.LongDef;
import androidx.annotation.Nullable;

public class ServiceClass extends Service {

    private static final String TAG="ServiceClass";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

      /*  try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       */
      AsyncTaskingClass asyncTaskingClass=new AsyncTaskingClass();
      asyncTaskingClass.execute(10000);
        return super.onStartCommand(intent, flags, startId);
    }
    class AsyncTaskingClass extends AsyncTask<Integer,Void,Void>{
        private static final String TAG = "AsyncTaskingClass";

        @Override
        protected Void doInBackground(Integer... integers) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "doInBackground: "+currentThread);
            int sleepTime=integers[0];
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onPreExecute: "+currentThread);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onPostExecute: "+currentThread);
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onProgressUpdate: "+currentThread);
            super.onProgressUpdate(values);
        }
    }
}
