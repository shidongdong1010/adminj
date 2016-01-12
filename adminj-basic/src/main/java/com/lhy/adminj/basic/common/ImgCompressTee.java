package com.lhy.adminj.basic.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩处理, 压缩成多规格的图片
 * 
 * @author SDD
 */
@SuppressWarnings("restriction")
public class ImgCompressTee {
	private byte data[];
	private String outFileName;
	private int[] widths = { 100, 200, 400 };
	private int[] heights = widths;
	private String[] suffixs = { "@1x", "@2x", "@3x" };

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		System.out.println("开始：" + new Date().toLocaleString());
		ImgCompressTee imgCom = new ImgCompressTee(new FileInputStream(
				"D:/sail/8/1442904434202@1x.jpg"),
				"D:/sail/8/1442904434202.jpg");
		imgCom.resizeFix();

		System.out.println("结束：" + new Date().toLocaleString());
	}

	/**
	 * 构造函数
	 */
	public ImgCompressTee(InputStream in, String outFileName)
			throws IOException {
		data = toByteArray(in); // 构造Image对象
		this.outFileName = outFileName;
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param widths
	 *            宽度
	 * @param heights
	 *            高度
	 * @param suffixs
	 *            后缀
	 */
	public void resizeFix() throws IOException {
		for (int i = 0; i < widths.length; i++) {
			int w = widths[i];
			int h = heights[i];
			String suffix = suffixs[i];
			String fileName = outFileName.replace(".jpg", "") + suffix + ".jpg";
			resize(w, h, fileName, new ByteArrayInputStream(data));
		}
		data = null;
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param widths
	 *            宽度
	 * @param heights
	 *            高度
	 * @param suffixs
	 *            后缀
	 */
	public void resizeFix(int[] widths, int[] heights, String[] suffixs)
			throws IOException {
		for (int i = 0; i < widths.length; i++) {
			int w = widths[i];
			int h = heights[i];
			String suffix = suffixs[i];
			String fileName = outFileName.replace(".jpg", "") + suffix + ".jpg";
			resize(w, h, fileName, new ByteArrayInputStream(data));
		}
		data = null;
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 */
	public void resize(int w, int h, String fileName, InputStream in)
			throws IOException {
		BufferedImage img = ImageIO.read(in);

		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图

		File destFile = new File(fileName);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流

		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		image.flush();
		out.flush();
		out.close();
	}

	public static byte[] toByteArray(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 4];
		int n = 0;
		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}
}
