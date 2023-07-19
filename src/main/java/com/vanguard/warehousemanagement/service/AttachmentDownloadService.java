package com.vanguard.warehousemanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface AttachmentDownloadService {
   void setSaveDirectory(String dir);
   void downloadEmailAttachments(String host, String port, String userName, String password);
}
