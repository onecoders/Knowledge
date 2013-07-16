package com.filetest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperTest {

	static String OLD_PATH = File.separator + "home" + File.separator
			+ "silicon" + File.separator + "file.test";
	static String NEW_PATH = File.separator + "home" + File.separator
			+ "silicon" + File.separator + "Documents" + File.separator
			+ "newfile.txt";

	static void renameTo1(String oldpath, String newpath) {
		new File(oldpath).renameTo(new File(newpath));
	}

	static void renameTo2(String oldpath, String newpath) {
		try {
			write(newpath, read(oldpath));
			new File(oldpath).delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static byte[] read(String readFrom) throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				new File(readFrom)));
		byte[] buff = new byte[bis.available()];
		bis.read(buff);
		return buff;
	}

	private static void write(String writeTo, byte[] buff) throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(new File(writeTo)));
		bos.write(buff);
		bos.flush();
		bos.close();
	}

	public static void main(String[] args) {
		long currentTime1 = System.currentTimeMillis();
		renameTo1(OLD_PATH, NEW_PATH);
		renameTo1(NEW_PATH, OLD_PATH);
		renameTo1(OLD_PATH, NEW_PATH);
		renameTo1(NEW_PATH, OLD_PATH);
		renameTo1(OLD_PATH, NEW_PATH);
		renameTo1(NEW_PATH, OLD_PATH);
		long currentTime2 = System.currentTimeMillis();
		
		
		long currentTime3 = System.currentTimeMillis();
		renameTo2(OLD_PATH, NEW_PATH);
		renameTo2(NEW_PATH, OLD_PATH);
		renameTo2(OLD_PATH, NEW_PATH);
		renameTo2(NEW_PATH, OLD_PATH);
		renameTo2(OLD_PATH, NEW_PATH);
		renameTo2(NEW_PATH, OLD_PATH);
		long currentTime4 = System.currentTimeMillis();
		
		long time1 = currentTime2 - currentTime1;
		System.out.println("time1:" + time1);
		long time2 = currentTime4 - currentTime3;
		System.out.println("time2:" + time2);
	}

}
