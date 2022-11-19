package com.dream.web.controller;

import com.dream.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by huzejun
 * on 2019/4/3 13:30
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "D:/code/SecurityProjects/dream-security-demo/src/main/java/com/dream/web/controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());


        File localFile = new File(folder, new Date().getTime()+ ".txt");

        file.transferTo(localFile);

        return new com.dream.dto.FileInfo(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
                ){

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }

    
    }

}
