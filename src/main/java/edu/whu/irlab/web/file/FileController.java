package edu.whu.irlab.web.file;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roger on 2016/5/26.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    /**
     * 下载文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/")+ File.separator+"download" + File.separator +"download.txt";
        System.out.println("download:"+path);
        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName = "download.txt";
        // String fileName=new String("你好.xlsx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传文件
     *
     * @param multipartFile
     * @param request
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> upload(MultipartFile multipartFile,
                      HttpServletRequest request){
        Map<String, String> map = new HashMap<>();
        map.put("msg", "上传失败");
        String path = request.getSession().getServletContext().getRealPath("/")+ File.separator+"upload" + File.separator +multipartFile.getOriginalFilename();
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(multipartFile.getBytes());
            fos.close();

            System.out.println("upload:"+path);
            map.put("msg", "上传成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
