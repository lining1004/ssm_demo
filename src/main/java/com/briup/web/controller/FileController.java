package com.briup.web.controller;

import com.briup.utils.Result;
import com.briup.utils.ResultUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 实现文件上传和下载
 * 下载： 本质将文件的字节流信息写出到响应体，浏览器解析
 * @Author lining
 * @Date 2022/10/17
 */
@Controller
public class FileController {
    @GetMapping("/download/{filename}")
    @ResponseBody
    public ResponseEntity<byte[]> downLoad(@PathVariable String filename) throws Exception{
        //1.设置响应状态：
        HttpStatus status = HttpStatus.OK;
        //2.设置响应头信息
        HttpHeaders headers = new HttpHeaders();

        //当下载的文件名字为中文名，设置文件名编码格式为iso-8859-1
        //utf-8 转换为 iso-8859-1 解决浏览器下载附件名乱码
        byte[] bytes = filename.getBytes("utf-8");
        String newFileName = new String(bytes, "iso-8859-1");


        //响应头信息告诉浏览器当前的信息byte 以附件的形式进行下载 内联的方式显示的在浏览器中
        headers.setContentDispositionFormData("attachment",newFileName);



        //3.设置响应体： 读取文件实现获取文件字节信息
        FileInputStream fis = new FileInputStream("E:/test/" + filename);
        //创建一个容器byte[]
        byte[] body = new byte[fis.available()];
        fis.read(body);
        return new ResponseEntity(body,headers,status);
    }
    /*
       Content-Type:multipart类型的数据
       1.表单实现上传文件
       <input type=file>
       2.ajax实现上传文件
        springMVC 所有的路径资源都要通过dispatcherServlet
        提供一个处理器方法,返回页码



     */
    @PostMapping("/upload/form")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile[] files) throws IOException {
        //1.遍历数组，获取每个上传文件信息MultipartFile表示
        for (MultipartFile file: files) {
            boolean empty = file.isEmpty();//文件是否空
            //1.获取下载的文件名
            String fileName = file.getOriginalFilename();
            System.out.println("文件名："+fileName);
            long size = file.getSize();
            System.out.println("文件大小："+size);
            //2.将文件保存到指定的位置
            /*
                用户上传文件时，文件的名称不确定，可能存在重复名字。
                使用时间戳
                使用随机数
             */
            //创建文件保存唯一id
            String uuid = UUID.randomUUID().toString().replace("-","");

            file.transferTo(new File("E:/test/",uuid+"-"+fileName));
        }
        return ResultUtil.success();
    }
    @PostMapping("/upload/ajax")
    @ResponseBody
    public String uploadAjax(@RequestParam("myfile") MultipartFile[] files) throws IOException {
        //1.遍历数组，获取每个上传文件信息MultipartFile表示
        for (MultipartFile file: files) {
            boolean empty = file.isEmpty();//文件是否空
            //1.获取下载的文件名
            String fileName = file.getOriginalFilename();
            System.out.println("文件名："+fileName);
            long size = file.getSize();
            System.out.println("文件大小："+size);
            //2.将文件保存到指定的位置
            /*
                用户上传文件时，文件的名称不确定，可能存在重复名字。
                使用时间戳
                使用随机数
             */
            //创建文件保存唯一id
            String uuid = UUID.randomUUID().toString().replace("-","");

            file.transferTo(new File("E:/test/",uuid+"-"+fileName));
        }
        return "上传文件成功";//表示返回的字符串编码为utf-8
    }

}
