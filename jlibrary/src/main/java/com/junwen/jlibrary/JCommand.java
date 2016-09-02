package com.junwen.jlibrary;

import java.io.File;
import java.math.BigDecimal;

/**
*描述:通用类
*作者:卜俊文
*邮箱:344176791@qq.com
*创建时间: 2016/8/11 15:52
*/
public class JCommand {
	
	/**
	*描述:删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
	*作者:卜俊文
	*邮箱:344176791@qq.com
	*创建时间: 2016/8/11 15:51
	*/
	static void deleteFilesByDirectory(File directory) {
		if (directory != null && directory.exists() && directory.isDirectory()) {
			for (File item : directory.listFiles()) {
				item.delete();
			}
		}
	}

	/**
	*描述:格式化单位
	*作者:卜俊文
	*邮箱:344176791@qq.com
	*创建时间: 2016/8/11 15:52
	*/
	public static String getFormatSize(double size) {
		double kiloByte = size / 1024;
		if (kiloByte < 1) {
			return size + "Byte";
		}

		double megaByte = kiloByte / 1024;
		if (megaByte < 1) {
			BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
			return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "KB";
		}

		double gigaByte = megaByte / 1024;
		if (gigaByte < 1) {
			BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
			return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "MB";
		}

		double teraBytes = gigaByte / 1024;
		if (teraBytes < 1) {
			BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
			return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "GB";
		}
		BigDecimal result4 = new BigDecimal(teraBytes);
		return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
				+ "TB";
	}
}
