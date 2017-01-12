package com.alyenc.cnaps.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFilter {

	BufferedImage image;
	private int imgWidth;
	private int imgHeight;
	private int[] pixels;

	public ImageFilter(BufferedImage image) {
		this.image = image;
		imgWidth = image.getWidth();
		imgHeight = image.getHeight();
		pixels = new int[imgWidth * imgHeight];
	}

	public void grayImage() {
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage grayImage = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_BYTE_GRAY);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// 计算灰度值
				final int color = image.getRGB(x, y);
				final int r = (color >> 16) & 0xff;
				final int g = (color >> 8) & 0xff;
				final int b = color & 0xff;
				int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
				int newPixel = colorToRGB(255, gray, gray, gray);
				grayImage.setRGB(x, y, newPixel);
			}
		}
		this.image = grayImage;
	}

	private static int colorToRGB(int alpha, int red, int green, int blue) {
		int newPixel = 0;
		newPixel += alpha;
		newPixel = newPixel << 8;
		newPixel += red;
		newPixel = newPixel << 8;
		newPixel += green;
		newPixel = newPixel << 8;
		newPixel += blue;
		return newPixel;

	}

	public void zoomPicture() {  
        int zoomWidth = (int) (((double) image.getWidth(null)) * 2);  
        int zoomHeight = (int) (((double) image.getHeight(null)) * 2);  
        BufferedImage zoomImage = new BufferedImage((int) zoomWidth,(int) zoomHeight,this.image.getType());  
        Graphics grap = zoomImage.getGraphics();
        grap.drawImage(this.image, 0,0,zoomWidth,zoomHeight,null);
        grap.dispose();
        this.image = zoomImage;
        imgWidth = zoomWidth;
		imgHeight = zoomHeight;
		pixels = new int[imgWidth * imgHeight];
    }  
	public static BufferedImage Pretreatment(String path) throws IOException {
		FileInputStream fin = new FileInputStream(path);
		BufferedImage bi = ImageIO.read(fin);
		ImageFilter flt = new ImageFilter(bi);
		flt.grayImage();
//		flt.zoomPicture();
		return flt.image;
	}
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("G:\\dynamicPassword.jpg");
		BufferedImage bi = ImageIO.read(fin);
		ImageFilter flt = new ImageFilter(bi);
		flt.grayImage();
//		flt.zoomPicture();
		File file = new File("G:\\img.jpg");
		ImageIO.write(flt.image,"jpg", file);
	}
}