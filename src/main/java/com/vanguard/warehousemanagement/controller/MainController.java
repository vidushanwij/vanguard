package com.vanguard.warehousemanagement.controller;

import com.vanguard.warehousemanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    DownloadConfigService downloadConfigService;
    @Autowired
    AttachmentDownloadService attachmentDownloadService;
    @Autowired
    FileReadService fileReadService;
    @Autowired
    TextProcessingService textProcessingService;


    @GetMapping(value = "/mail/download")
    public void downloadEmail() {
        attachmentDownloadService.setSaveDirectory(downloadConfigService.getSaveDirectory());
        attachmentDownloadService.downloadEmailAttachments(downloadConfigService.getHost(), downloadConfigService.getPort(), downloadConfigService.getUserName(), downloadConfigService.getPassword());
    }

    @GetMapping(value = "/start")
    public String readFile() {
        return fileReadService.read();
    }

    @RequestMapping(value = "/parse")
    public void parseText(){
        textProcessingService.textParser();
    }
}
