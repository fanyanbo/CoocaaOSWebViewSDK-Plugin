package com.example.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.coocaa.plugin.support.activity.PluginActivity;

import org.apache.cordova.CordovaActivity;

/**
 * Created by fanyanbo on 2018/8/16.
 * Email: fanyanbo@skyworth.com
 */
public class WebXActivity extends CordovaActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TEST","onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TEST","onStart");

        String url = getIntent().getExtras().getString("url");
        Log.i("TEST","onStart getParams url = " + url);
        loadUrl(url);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TEST","onResume");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i("TEST","onRestart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TEST","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TEST","onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TEST","onDestroy");
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
