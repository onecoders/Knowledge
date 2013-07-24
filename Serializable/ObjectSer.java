package com.filetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSer {

	private static void save(Student stu) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					"/home/silicon/data.ser"));
			oos.writeObject(stu);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static Student read() {
		Student stu = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(
					"/home/silicon/data.ser"));
			stu = (Student) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stu;
	}

	public static void main(String[] args) {
		Student stu = new Student(981036, "LiuMing", 18, "CSD");
		save(stu);
		stu = null;
		stu = read();
		System.out.println(stu.id);
		System.out.println(stu.name);
		System.out.println(stu.age);
		System.out.println(stu.department);
	}

}
