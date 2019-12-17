package com.dandelion.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 图片验证码生成工具类
 * @author puyiliang
 * @date create in 2019/12/179:27
 */
public class PictureVerificationCodeUtil {

    /**
     * 图片的宽度。
     */
    private int width = 110;
    /**
     * 图片的高度。
     */
    private int height = 40;
    /**
     * 验证码字符个数。
     */
    private int codeCount = 4;
    /**
     * 验证码干扰线数。
     */
    private int lineCount = 5;
    /**
     * 验证码。
     */
    private String code = null;
    /**
     * 验证码图片Buffer。
     */
    private BufferedImage buffImg = null;
    /**
     * 允许的选择。排除 0,o,1,i,l 等易混淆选项
     */
    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     *字体数组
     */
    private String[] fontNames = {"Georgia"};
    /**
     * 生成随机数。
     */
    private Random random = new Random();

    public PictureVerificationCodeUtil() {
        this.createCode();
    }

    /**
     *
     * @param width 图片宽
     * @param height 图片高
     */
    public PictureVerificationCodeUtil(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     *
     * @param width 图片宽
     * @param height 图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public PictureVerificationCodeUtil(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        // 每个字符的宽度
        int codeX = width / (codeCount + 3);
        // 字体的高度
        int fontHeight = height - 5;
        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体
        Font font = getRandomFont();
        g.setFont(font);

        StringBuffer randomCode = new StringBuffer();
        // 随机产生验证码字符
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 设置字体颜色
            g.setColor(getRandomColor());
            // 设置字体位置
            g.drawString(strRand, (i + 1) * codeX, fontHeight);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
        drawLine(buffImg);
    }

    /** 获取随机颜色 */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /**
     * 画干扰线，验证码干扰线用来防止计算机解析图片
     * @param image BufferedImage
     */
    private void drawLine(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < lineCount; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.setColor(getRandomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 获取随机字体
     * @return Font
     */
    private Font getRandomFont() {
        //获取随机的字体
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];
        //随机获取字体的样式，0是无样式，1是加粗，2是斜体，3是加粗加斜体
        int style = random.nextInt(4);
        //随机获取字体的大小
        int size = random.nextInt(10) + 24;
        //返回一个随机的字体
        return new Font(fontName, style, size);
    }

    /** 获取随机数 */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public String getCode() {
        return code;
    }

}
