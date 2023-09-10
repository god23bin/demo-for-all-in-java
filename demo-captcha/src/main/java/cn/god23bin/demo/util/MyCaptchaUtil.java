package cn.god23bin.demo.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author god23bin
 * @created 2023/6/6 20:47
 */
public class MyCaptchaUtil {

    /**
     * 生成 n 位验证码
     * @param n 位数
     * @return n 位验证码
     **/
    public static String generateCode(int n) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * 生成 n 位的图片验证码
     * @param n 位数
     * @return 哈希表，code 获取文本验证码，img 获取 BufferedImage 图片对象
     **/
    public static Map<String, Object> generateCodeImage(int n) {
        int width = 100, height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            char c = chars.charAt(index);
            sb.append(c);
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString(Character.toString(c), 20 + i * 15, 25);
        }
        Map<String, Object> res = new HashMap<>();
        res.put("code", sb.toString());
        res.put("img", image);
        return res;
    }

}
