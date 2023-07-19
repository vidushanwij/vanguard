package com.vanguard.warehousemanagement.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("download-service")
public class DownloadConfigService {
    private String host;
    private String port;
    private String userName;

    public String getPassword() {
        String password = "apeetqywxcebuuzw";
        return password;
    }

    public String getSaveDirectory() {
        String saveDirectory = "E:/Attachment";
        return saveDirectory;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
