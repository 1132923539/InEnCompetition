package com.bs.competition.control.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/*import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;*/

public class ImageUtil {

	private File inputFile; // 文件对象
	private File outputFile; // 输出图路径
	private int outputWidth; // 默认输出图片宽
	private int outputHeight; // 默认输出图片高
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

	public boolean compressPic() {
		try {
			// 获得源文件
			if (!inputFile.exists()) {
				return false;
			}
			Image img = ImageIO.read(inputFile);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return false;
			} else {
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (this.proportion == true) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth + 0.1;
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (img.getWidth(null) / rate);
					newHeight = (int) (img.getHeight(null) / rate);
				} else {
					newWidth = outputWidth; // 输出的图片宽度
					newHeight = outputHeight; // 输出的图片高度
				}
				BufferedImage tag = new BufferedImage(newWidth, newHeight,
						BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				FileOutputStream out = new FileOutputStream(outputFile);
				// JPEGImageEncoder可适用于其他图片类型的转换
				 String dstName= outputFile.getAbsolutePath();
				 String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);  
				 
				ImageIO.write(tag, formatName, outputFile);
				out.close();
			}
		} catch (IOException ex) {
			return false;
		}
		return true;
	}

	public boolean compressPic(File inputFile, File outputFile, int width,
			int height, boolean gp) {
		// 输入图路径
		this.inputFile = inputFile;
		// 输出图路径
		this.outputFile = outputFile;
		// 设置图片长宽
		this.outputWidth = width;
		this.outputHeight = height;
		// 是否是等比缩放 标记
		this.proportion = gp;
		return compressPic();
	}

	public void compressPic2(File inputFile, File outputFile, int width,
			int height, boolean gp, int maxSize) {
		File ori = inputFile;
		File out = outputFile;
		this.compressPic(ori, out, width, height, true);// 一次
		if (out.length() > maxSize) {
			ori = out;
			this.compressPic(ori, out, width, height, true);// 二次
		}
		if (out.length() > maxSize) {
			ori = out;
			width = width - 1;
			compressPic2(ori, out, width, height, gp, maxSize);// 减少比例
		}
	}

	public static void byteToImage(byte[] image) {

	}

	/**
	 * 截图并得到其中的字节
	 */
	public static byte[] getCutImageByte(File tempOld, int startX, int startY,
			int width, int height, File tempNew) {

		try {

			BufferedImage oldImage = ImageIO.read(tempOld);
			BufferedImage newImage = oldImage.getSubimage(startX, startY,
					width, height);
			String contentType = tempNew.getAbsolutePath();
			ImageIO.write(newImage,
					contentType.substring(contentType.indexOf(".") + 1),
					tempNew);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BufferedImage subImg = null;

	/**
	 * 截图
	 */
	public BufferedImage cut(String srcPath, int startX, int startY, int width,
			int height) {

		try {
			BufferedImage bufImg = ImageIO.read(new File(srcPath));
			BufferedImage subImg = bufImg.getSubimage(startX, startY, width,
					height);
			return subImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存截图
	 */
	public void save(String imgType, String imgName, String tarPath, int width,
			int height) {

		try {// 压缩图片为指定尺寸
			if (subImg.getWidth() != width || subImg.getHeight() != height) {
				BufferedImage tempImg = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				tempImg.getGraphics().drawImage(
						subImg.getScaledInstance(width, height,
								Image.SCALE_SMOOTH), 0, 0, null);
				ImageIO.write(tempImg, imgType, new File(tarPath + "/"
						+ imgName));
			} else {
				ImageIO.write(subImg, imgType,
						new File(tarPath + "/" + imgName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
