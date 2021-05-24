package com.huang.controller.commonDistingush;

import com.chinamobile.cmss.sdk.util.JacksonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huang.mapper.employmeemapper;
import com.huang.pojo.employmee;
import com.huang.utils.JsonRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class commonDistingush {
    @Autowired
    com.huang.mapper.employmeemapper employmeemapper;

    @RequestMapping("/common")
    public JsonRes test2(@RequestParam("files") MultipartFile[] files, HttpServletResponse response) {
        JsonRes res = new JsonRes();
        res.setState(String.valueOf(response.getStatus())); //获得当前浏览器的状态
        res.setErrorCode(null);
        res.setErrorMessage(null);
        String[] info = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            byte[] data = null;
            InputStream in = null;
            try {
                in = files[i].getInputStream();
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //对字节数组进行base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            String tpjiema = encoder.encode(data);
            info[i] = pictureShibie.tongyongshibie(tpjiema);
        }
        res.setInformation(Arrays.toString(info));
        return res;

    }

}
