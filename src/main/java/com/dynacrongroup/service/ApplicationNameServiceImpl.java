package com.dynacrongroup.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationNameServiceImpl implements ApplicationNameService {

    private String appName;
    private String appVersion;

    // wired-in during configuration
    @Autowired
    private ApplicationNameServiceImpl(String appName, String appVersion) {
        this.appName = appName;
        this.appVersion = appVersion;
    }

    @Override
    public String getName() {
        return appName;
    }

    @Override
    public String getVersion() {
        return appVersion;
    }
}
