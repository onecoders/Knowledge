package com.filetest;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * if not implements Serializable, will cause java.io.NotSerializableException
	 */
	private static final long serialVersionUID = 521042074600784463L;

	int id;
	String name;
	int age;
	String department;

	public Student(int id, String name, int age, String department) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
	}

}
