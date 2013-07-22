package my.handrite.generalfs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.util.List;

import android.os.Handler;

import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFileInfo;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;
import com.dropbox.sync.android.DbxPath.InvalidPathException;

public class DbxFile implements GeneralFile {

	private DbxFileSystem dbxFS;
	private com.dropbox.sync.android.DbxFile dbxFile;
	private DbxPath dbxPath;

	public DbxFile(DbxFileSystem dbxFS, String path) {
		this.dbxFS = dbxFS;
		this.dbxPath = new DbxPath(path);
		try {
			this.dbxFile = dbxFS.create(dbxPath);
		} catch (DbxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() throws FSException {
		try {
			if (exists()) {
				dbxFS.delete(dbxPath);
			}
		} catch (DbxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void renameTo(GeneralFile newPath) throws FSException {
		if (newPath instanceof LocalFile) {
			try {
				copy(newPath);
				delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (newPath instanceof DbxFile) {
			try {
				dbxFS.move(dbxFile.getPath(),
						new DbxPath(newPath.getAbsolutePath()));
			} catch (InvalidPathException e) {
				e.printStackTrace();
			} catch (DbxException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void copy(GeneralFile dest) throws IOException, FSException {
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(dbxFile.getReadStream());
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
		List<String> list = null;
		try {
			if (isDirectory()) {
				List<DbxFileInfo> infoList = dbxFS.listFolder(dbxPath);
				for (DbxFileInfo dbxFileInfo : infoList) {
					list.add(dbxFileInfo.path.getName());
				}
			}
		} catch (DbxException e) {
			e.printStackTrace();
		}
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				cb.runAtTimeout(50);
			}
		}, cb.getTimeoutMillis());
		cb.runAtFinish(list);
	}

	@Override
	public void write(byte[] buff) throws IOException {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(dbxFile.getWriteStream());
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
			bis = new BufferedInputStream(dbxFile.getReadStream());
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
		try {
			ObjectInputStream ois = new ObjectInputStream(
					dbxFile.getReadStream());
			obj = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		return dbxFile.getPath().getName();
	}

	@Override
	public boolean isDirectory() {
		try {
			return dbxFS.isFolder(dbxPath);
		} catch (DbxException e) {
			return false;
		}
	}

	@Override
	public boolean exists() {
		try {
			return dbxFS.exists(dbxPath);
		} catch (DbxException e) {
			return false;
		}
	}

	@Override
	public long lastModified() {
		try {
			return dbxFile.getInfo().modifiedTime.getTime();
		} catch (DbxException e) {
			return 0;
		}
	}

}
