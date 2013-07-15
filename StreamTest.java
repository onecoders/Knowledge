package com.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class StreamTest {

	private static byte[] read(File file) throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));
		byte[] buff = new byte[bis.available()];
		bis.read(buff);
		return buff;
	}

	private static void write(File file, byte[] buff) throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(file));
		bos.write(buff);
		bos.flush();
		bos.close();
	}

	public static void copy(File copyFrom, File copyTo) throws Exception {
		write(copyTo, read(copyFrom));
	}

	public static void copy2(File copyFrom, File copyTo) throws Exception {
		if (!copyTo.exists()) {
			copyTo.createNewFile();
		}
		FileChannel source = null;
		FileChannel dest = null;
		try {
			source = new FileInputStream(copyFrom).getChannel();
			dest = new FileOutputStream(copyTo).getChannel();
			dest.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (dest != null) {
				dest.close();
			}
		}
	}

	public static void rename1(File renameFrom, File renameTo) throws Exception {
		copy(renameFrom, renameTo);
		renameFrom.delete();
	}

	public static void rename2(File renameFrom, File renameTo) {
		renameFrom.renameTo(renameTo);
	}

	public static void main(String[] args) {
		String copyFromStr = "/home/silicon/hello.txt";
		String copyToStr = "/home/silicon/copy.txt";
		File copyFrom = new File(copyFromStr);
		File copyTo = new File(copyToStr);
		try {
			copy2(copyFrom, copyTo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String renameFromStr = "/home/silicon/copy.txt";
		String renameToStr = "/home/silicon/test.txt";
		File renameFrom = new File(renameFromStr);
		File renameTo = new File(renameToStr);
		try {
			rename1(renameFrom, renameTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
