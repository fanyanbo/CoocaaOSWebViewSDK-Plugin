package com.example.hostapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.coocaa.plugin.manager.PluginManager;
import com.coocaa.plugin.manager.loadparams.PluginParams;
import com.coocaa.plugin.manager.loadparams.PluginParamsHelper;
import com.coocaa.plugin.plugindata.PluginData;
import com.coocaa.plugin.support.LaunchHelper;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filePath = "/data/app/com.example.pluginapp-1.apk";
        String dexDir = this.getFilesDir().getAbsolutePath() ;
        Log.i("TEST","dexDir = " + dexDir);
        PluginParams params = PluginParamsHelper.createApkPluginParams(filePath, dexDir, null);
        PluginData pluginData = PluginManager.getInstance().loadPlugin(params, this);

        Log.i("TEST","pluginData = " + pluginData);

        String pluginClassName = "com.example.pluginapp.WebXActivity";

        Bundle bundle = new Bundle();
        bundle.putInt("test",123);
        bundle.putString("url","https://www.baidu.com");
        LaunchHelper.launchActivity(this, pluginClassName, pluginData,null,bundle);
//        String url = "https://www.baidu.com";
//        loadUrl(url);
    }
}
