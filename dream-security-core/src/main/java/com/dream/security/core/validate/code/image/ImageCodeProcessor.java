package com.dream.security.core.validate.code.image;

import com.dream.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * 图片验证码处理器
 * Created by huzejun
 * on 2019/4/19 15:15
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     * @param request
     * @param imageCode
     * @throws IOException
     */
    @Override
    protected void send(ServletWebRequest request,ImageCode imageCode) throws IOException {
        ImageIO.write(imageCode.getImage(), "JPEG",request.getResponse().getOutputStream());
    }

}
