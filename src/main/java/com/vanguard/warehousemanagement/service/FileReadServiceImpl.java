package com.vanguard.warehousemanagement.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileReadServiceImpl implements FileReadService{

    private String text;
    private File directory ;

    public String getText() {
        return text;
    }

    public File getDirectory() {
        return directory;
    }

    public String read(){
        try{
            File file = new File("E:/Attachment/Wrehouse update.pdf");
            PDDocument document = PDDocument.load(file);
            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            text = pdfStripper.getText(document);
            System.out.println(text);
            //Closing the document
            document.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return text;
    }

    // have to call and test this
    @Override
    public void cleanDirectory() {
        directory=new File("/Users/Vidu/Documents/temp");
        try {
            FileUtils.cleanDirectory(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
