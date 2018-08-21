package com.example.hostapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.coocaa.plugin.manager.PluginManager;
import com.coocaa.plugin.manager.loadparams.PluginParams;
import com.coocaa.plugin.manager.loadparams.PluginParamsHelper;
import com.coocaa.plugin.plugindata.PluginData;
import com.coocaa.plugin.support.LaunchHelper;

import coocaa.libcommon.WebBridge;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filePath = "/data/app/com.example.pluginapp-1.apk";
        String dexDir = this.getFilesDir().getAbsolutePath();
        Log.i("TEST", "dexDir = " + dexDir);
        // 未安裝apk
//        PluginParams params = PluginParamsHelper.createApkPluginParams(filePath, dexDir, null);
//        PluginData pluginData = PluginManager.getInstance().loadPlugin(params, this);

        // 已安裝apk
        PluginParams params = PluginParamsHelper.createAppPluginParams("com.example.pluginapp");
        PluginData pluginData = PluginManager.getInstance().loadPlugin(params, this);

        WebBridge.IWebPageListener listener = new WebBridge.IWebPageListener() {
            @Override
            public void onPageStarted(String url) {
                Log.i("TEST","host onPageStarted url = " + url);
            }

            @Override
            public void onPageFinished(String url) {
                Log.i("TEST","host onPageFinished url = " + url);
            }

            @Override
            public void onProgressChanged(int newValue) {
                Log.i("TEST","host onProgressChanged value = " + newValue);
            }
        };

        WebBridge.IWebPlugin plugin = (WebBridge.IWebPlugin) pluginData.getClassInstance("com.example.pluginapp.PluginImpl");
        plugin.setListener(listener);

        Log.i("TEST", "pluginData = " + pluginData);

        String pluginClassName = "com.example.pluginapp.WebXActivity";

        Bundle bundle = new Bundle();
        bundle.putString("url", "https://www.sina.com");
        LaunchHelper.launchActivity(this, pluginClassName, pluginData, null, bundle);


//        String url = "https://www.baidu.com";
//        loadUrl(url);
    }
}
