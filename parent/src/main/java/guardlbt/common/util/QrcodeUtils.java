package guardlbt.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrcodeUtils {

    /**
     * 画二维码
     *
     * @param qrcodePath 存放二维码路径
     * @param content    二维码内容
     * @param height     二维码高度
     * @param width      二维码宽度
     */
    public static void drawQrcode(String qrcodePath, String content, int height, int width) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            //设置UTF-8， 防止中文乱码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //设置二维码四周白色区域的大小
            hints.put(EncodeHintType.MARGIN, 1);
            //设置二维码的容错性
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //画二维码，记得调用multiFormatWriter.encode()时最后要带上hints参数，不然上面设置无效
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            //qrcFile用来存放生成的二维码图片（无logo，无文字）
            File qrcodeFile = QrcodeUtils.findFile(qrcodePath);
            //开始画二维码
            MatrixToImageWriter.writeToFile(bitMatrix, "jpg", qrcodeFile);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param qrcodePath     二维码路径
     * @param textQrcodePath 存放文字二维码路径
     * @param width          文字二维码宽度
     * @param height         文字二维码高度
     * @param qrcodeFont 文字内容集合
     * @给二维码添加文字
     */
    public static void pressText(String qrcodePath, String textQrcodePath, int width, int height,  QrcodeFont qrcodeFont) {

        try {
            File textQrcodeFile = findFile(qrcodePath);
            Image src = ImageIO.read(textQrcodeFile);
            int imageW = src.getWidth(null);
            int imageH = src.getHeight(null);
            BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.setColor(Color.WHITE);//设置笔刷白色
            g.fillRect(0, 0, width, height);//填充整个屏幕
            g.drawLine(0, 0, imageW, imageH);
            g.drawImage(src, 5, 5, imageW-10, imageH-50, null);
            g.setColor(qrcodeFont.getColor());
            g.setFont(new Font("粗体", qrcodeFont.getFontStyle(), qrcodeFont.getFontSize()));
            g.drawString(qrcodeFont.getText(), qrcodeFont.getStartX(), qrcodeFont.getStartY());
            g.dispose();
            FileOutputStream out = new FileOutputStream(textQrcodePath);
            ImageIO.write(image, "jpg", out);
            //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            //encoder.encode(image);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param filepath
     * @return
     * @查找文件（没有则创建文件）
     */
    public static File findFile(String filepath) {
//        File file = new File(filepath);
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        return file;

        File outputFile = new File(filepath);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  outputFile;
    }

    /**
     * 生成带手工码的二维码图片
     * @param qrCodePath
     * @param qrContent
     * @param textQrContent
     */
    public static  void drawQrCodeWithTxt(String qrCodePath,String qrContent,String textQrContent){
             QrcodeUtils.drawQrcode(qrCodePath, qrContent, 400, 400);
            //二维码文字的位置
            QrcodeFont qrCodeFont = new QrcodeFont();
            qrCodeFont.setStartX(100);
            qrCodeFont.setStartY(380);
            qrCodeFont.setText(textQrContent);
            QrcodeUtils.pressText(qrCodePath, qrCodePath, 400, 400, qrCodeFont);
      }

}
