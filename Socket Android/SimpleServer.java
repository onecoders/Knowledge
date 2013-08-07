package com.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while (true) {
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			os.write("this is the message".getBytes("utf-8"));
			os.close();
			s.close();
		}
	}

}
