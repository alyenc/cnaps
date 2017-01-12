package com.alyenc.cnaps.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.alyenc.cnaps.utils.ImageFilter;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

/**
 * 验证码识别
 * Package com.alyenc.cnaps.service
 * @author alyenc@163.com
 * @date 2017年1月12日 上午9:35:59
 * @version 0.1.1
 */
public class AuthCode {

	public static String validate(String picPath) throws Exception{
		//前序图片处理(去除干扰线等)
		
		//调用识别接口
		String result = validPicture(picPath);
		return result;
	}
	
	private static String validPicture(String picPath) throws Exception{
		Tesseract tessreact = new Tesseract();
		String resPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		tessreact.setDatapath("G:\\tessdata"); 
		String result = "";
		try {
			BufferedImage image = ImageFilter.Pretreatment(picPath);
			result = tessreact.doOCR(image);
		} catch (TesseractException e) {  
			System.err.println(e.getMessage());  
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		
		System.out.println(validate("G:\\dynamicPassword.jpg"));
	}
}
