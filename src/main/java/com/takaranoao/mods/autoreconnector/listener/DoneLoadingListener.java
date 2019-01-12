package com.takaranoao.mods.autoreconnector.listener;

import com.takaranoao.mods.autoreconnector.AutoConnector;
import com.takaranoao.mods.autoreconnector.listenerdefinitions.DoneLoading;

public class DoneLoadingListener implements DoneLoading {
    @Override
    public void onDoneLoading() {
        AutoConnector.onDoneLoading();
    }
}
