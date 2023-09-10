package cn.god23bin.demo.controller;

import cn.god23bin.demo.util.MyCaptchaUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author god23bin
 * @created 2023/6/6 20:50
 */
@RequestMapping("/captcha")
@RestController
public class CaptchaController {

    @GetMapping("/code/custom")
    public void getCode(HttpServletResponse response) {
        Map<String, Object> map = MyCaptchaUtil.generateCodeImage(5);
        System.out.println(map.get("code"));
        BufferedImage img = (BufferedImage) map.get("img");

        // 设置响应头，防止缓存
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/png");
        try {
            ImageIO.write(img, "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/code/hutool")
    public void getCodeByHutool(HttpServletResponse response) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        System.out.println("线段干扰的验证码：" + lineCaptcha.getCode());

        // 设置响应头，防止缓存
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/png");
        try {
            lineCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private Producer kaptchaProducer;

    @GetMapping("/code/kaptcha")
    public void getCodeByKaptcha(HttpServletResponse response) {
        // 生成文字验证码
        String text = kaptchaProducer.createText();
        System.out.println("文字验证码：" + text);
        // 生成图片验证码
        BufferedImage image = kaptchaProducer.createImage(text);

        // 设置响应头，防止缓存
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
