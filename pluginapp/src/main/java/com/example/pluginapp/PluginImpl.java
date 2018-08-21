package com.example.pluginapp;

import coocaa.libcommon.WebBridge;

/**
 * Created by fanyanbo on 2018/8/21.
 * Email: fanyanbo@skyworth.com
 */
public class PluginImpl implements WebBridge.IWebPlugin {

    private static WebBridge.IWebPageListener listener = null;

    @Override
    public void setListener(WebBridge.IWebPageListener listener) {
        this.listener = listener;
    }


    public static WebBridge.IWebPageListener getListener() {
        return listener;
    }
}
