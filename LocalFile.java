package my.handrite.generalfs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Handler;

public class LocalFile implements GeneralFile {

	private File file;

	public LocalFile(String path) {
		this.file = new File(path);
	}

	@Override
	public void delete() throws FSException {
		file.delete();
	}

	@Override
	public void renameTo(GeneralFile newPath) throws FSException {
		if (newPath instanceof LocalFile) {
			file.renameTo(new File(newPath.getAbsolutePath()));
		} else if (newPath instanceof DbxFile) {
			try {
				copy(newPath);
				delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void copy(GeneralFile dest) throws IOException, FSException {
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			int temp = 0;
			while ((temp = bis.read(buff)) != -1) {
				dest.write(buff);
			}
		} finally {
			if (bis != null) {
				bis.close();
			}
		}
	}

	@Override
	public void list(final Callback<List<String>> cb) {
		List<String> fileList = new ArrayList<String>();
		if (isDirectory()) {
			fileList = Arrays.asList(file.list());
		}
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				cb.runAtTimeout(50);
			}
		}, cb.getTimeoutMillis());
		cb.runAtFinish(fileList);
	}

	@Override
	public void write(byte[] buff) throws IOException {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(buff);
			bos.flush();
		} finally {
			if (bos != null) {
				bos.close();
			}
		}
	}

	@Override
	public void readBytes(final Callback<ByteBuffer> cb) {
		BufferedInputStream bis = null;
		ByteBuffer byteBuffer = ByteBuffer.allocate(64);
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			int temp = 0;
			while ((temp = bis.read()) != -1) {
				byteBuffer.put((byte) temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				cb.runAtTimeout(50);
			}
		}, cb.getTimeoutMillis());
		cb.runAtFinish(byteBuffer);
	}

	@Override
	@Deprecated
	public void readObject(final Callback<Object> cb) {
		Object obj = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				cb.runAtTimeout(50);
			}
		}, cb.getTimeoutMillis());
		cb.runAtFinish(obj);
	}

	@Override
	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	@Override
	public boolean isDirectory() {
		return file.isDirectory();
	}

	@Override
	public boolean exists() {
		return file.exists();
	}

	@Override
	public long lastModified() {
		return file.lastModified();
	}

}
