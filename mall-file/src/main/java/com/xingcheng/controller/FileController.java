package com.xingcheng.controller;

import com.xingcheng.domain.Result;
import com.xingcheng.service.FileService;
import com.xingcheng.service.impl.LocalFileServiceImpl;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Resource
    private LocalFileServiceImpl iFileServices;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile file)
    {
        try
        {
            // 上传并返回访问地址
            return Result.success(iFileServices.uploadFile(file));
        }
        catch (Exception e)
        {
            log.error("上传文件失败", e);
            return Result.error(e.getMessage(),500);
        }
    }
}
