package com.dream.security.core.validate.code.image;

import com.dream.security.core.properties.SecurityProperties;
import com.dream.security.core.validate.code.ValidateCodeGenerator;
import com.dream.security.core.validate.code.image.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by huzejun
 * on 2019/4/11 18:59
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public ImageCode generate(ServletWebRequest request) {

            int width = ServletRequestUtils.getIntParameter(request.getRequest(),"width",securityProperties.getCode().getImage().getWidth());
            int height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",securityProperties.getCode().getImage().getHeigth());

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics graphics = image.getGraphics();

            Random random = new Random();

            graphics.setColor(getRandColor(200,250));
            graphics.fillRect(0,0,width,height);
            graphics.setFont(new Font("Times New Roman", Font.ITALIC,20));
            graphics.setColor(getRandColor(160,200));
            for (int i = 0; i < 155; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                graphics.drawLine(x,y,x+xl,y+yl);
            }

            String sRand = "";
            for (int i = 0; i < securityProperties.getCode().getImage().getLength() ; i++) {
                String rand = String.valueOf(random.nextInt(10));
                sRand += rand;
                graphics.setColor(new Color(20 + random.nextInt(100),20 + random.nextInt(110), 20 + random.nextInt(110)));
                graphics.drawString(rand, 13 * i + 6, 16);
            }

            graphics.dispose();

        return new ImageCode(image,sRand,securityProperties.getCode().getImage().getExpireIn());


//        return null;
    }

    /**
     * ????????????????????????
     * @param fc
     * @param bc
     * @return
     */
    public Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
