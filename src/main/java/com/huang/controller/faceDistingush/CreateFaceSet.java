package com.huang.controller.faceDistingush;

import com.chinamobile.bcop.api.sdk.ai.core.exception.ClientException;
import com.chinamobile.bcop.api.sdk.ai.core.model.CommonJsonObjectResponse;
import com.chinamobile.bcop.api.sdk.ai.facebody.AiFaceBody;
import com.huang.utils.JsonRes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CreateFaceSet {

    @RequestMapping("/faceset")
    public JsonRes faceset(HttpServletResponse response){
        JsonRes res = new JsonRes();
        res.setState(String.valueOf(response.getStatus())); //获得当前浏览器的状态
        res.setErrorCode(null);
        res.setErrorMessage(null);
        AiFaceBody aiFaceBody = FaceAi.getInstance();
        try {
            CommonJsonObjectResponse response1 = aiFaceBody.queryFaceSet(null, null, null, null, null);
            res.setInformation(response1.getCommonResult().toString());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return res;
    }

}
