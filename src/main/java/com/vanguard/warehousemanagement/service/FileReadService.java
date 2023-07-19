package com.vanguard.warehousemanagement.service;

import java.io.File;

public interface FileReadService {
    String read();
    void cleanDirectory();
    String getText();
    File getDirectory();

}
