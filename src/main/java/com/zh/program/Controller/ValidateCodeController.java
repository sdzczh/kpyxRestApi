package com.zh.program.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class ValidateCodeController {
    private static final String VALIDATE_CODE = "validateCode";
    private int w = 70;
    private int h = 23;

    /**
     * @throws Exception
     * 函数功能说明 ： 进入后台登陆页面.
     *
     * @参数： @return
     * @return String
     * @throws
     */
    @RequestMapping(value = "/validateCode")
    public void validateCode(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        createImage(request,response);
    }


    private void createImage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("p_w_picpath/jpeg");

        BufferedImage p_w_picpath = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = p_w_picpath.getGraphics();

        /*
         * 生成背景
         */
        createBackground(g);

        /*
         * 生成字符
         */
        String s = createCharacter(g);
        request.getSession().setAttribute(VALIDATE_CODE, s);

        g.dispose();
        OutputStream out = response.getOutputStream();
        ImageIO.write(p_w_picpath, "JPEG", out);
        out.close();

    }
    /**
     * 生成颜色
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc,int bc) {
        int f = fc;
        int b = bc;
        Random random=new Random();
        if(f>255) {
            f=255;
        }
        if(b>255) {
            b=255;
        }
        return new Color(f+random.nextInt(b-f),f+random.nextInt(b-f),f+random.nextInt(b-f));
    }

    /**
     * 生成背景
     * @param g
     */
    private void createBackground(Graphics g) {
        // 填充背景
        g.setColor(getRandColor(220,250));
        g.fillRect(0, 0, w, h);
        // 加入干扰线条
        for (int i = 0; i < 8; i++) {
            g.setColor(getRandColor(40,150));
            Random random = new Random();
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int x1 = random.nextInt(w);
            int y1 = random.nextInt(h);
            g.drawLine(x, y, x1, y1);
        }
    }

    /**
     * 生成字符
     * @param g
     * @return
     */
    private String createCharacter(Graphics g) {
        char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
                'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
        String[] fontTypes = {"Arial","Arial Black","AvantGarde Bk BT","Calibri"};
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
            g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)], Font.BOLD,26));
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));
//			g.drawString(r, i*w/4, h-5);
            s.append(r);
        }
        return s.toString();
    }
}
