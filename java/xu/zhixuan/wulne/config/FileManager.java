package xu.zhixuan.wulne.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import xu.zhixuan.wulne.UI.Account.Alt;
import xu.zhixuan.wulne.UI.Account.AltManager;
import xu.zhixuan.wulne.WulneJvav;

public class FileManager {
	private static File dir;

	static {
		final File mcDataDir = Minecraft.getMinecraft().mcDataDir;
		WulneJvav.INSTANCE.getClass();
		FileManager.dir = new File(mcDataDir, "WulneClient");
	}

	public FileManager() {
		super();
	}
	public static File getConfigFile(final String name) {
		final File file = new File(FileManager.dir, String.format("%s.txt", name));
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
			}
		}
		return file;
	}

	public static void init() {
		if (!FileManager.dir.exists()) {
			FileManager.dir.mkdir();
		}
	}

	public static List<String> read(final String file) {
		final List<String> out = new ArrayList<String>();
		try {
			if (!FileManager.dir.exists()) {
				FileManager.dir.mkdir();
			}
			final File f = new File(FileManager.dir, file);
			if (!f.exists()) {
				f.createNewFile();
			}
			Throwable t = null;
			try {
				final FileInputStream fis = new FileInputStream(f);
				try {
					final InputStreamReader isr = new InputStreamReader(fis);
					try {
						final BufferedReader br = new BufferedReader(isr);
						try {
							String line = "";
							while ((line = br.readLine()) != null) {
								out.add(line);
							}
						} finally {
							if (br != null) {
								br.close();
							}
						}
						if (isr != null) {
							isr.close();
						}
					} finally {
						if (t == null) {
							final Throwable t2 = null;
							t = t2;
						} else {
							final Throwable t2 = null;
							if (t != t2) {
								t.addSuppressed(t2);
							}
						}
						if (isr != null) {
							isr.close();
						}
					}
					if (fis != null) {
						fis.close();
						return out;
					}
				} finally {
					if (t == null) {
						final Throwable t3 = null;
						t = t3;
					} else {
						final Throwable t3 = null;
						if (t != t3) {
							t.addSuppressed(t3);
						}
					}
					if (fis != null) {
						fis.close();
					}
				}
			} finally {
				if (t == null) {
					final Throwable t4 = null;
					t = t4;
				} else {
					final Throwable t4 = null;
					if (t != t4) {
						t.addSuppressed(t4);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public static void save(final String file, final String content, final boolean append) {
		try {
			final File f = new File(FileManager.dir, file);
			if (!f.exists()) {
				f.createNewFile();
			}
			Throwable t = null;
			try {
				final FileWriter writer = new FileWriter(f, append);
				try {
					writer.write(content);
				} finally {
					if (writer != null) {
						writer.close();
					}
				}
			} finally {
				if (t == null) {
					final Throwable t2 = null;
					t = t2;
				} else {
					final Throwable t2 = null;
					if (t != t2) {
						t.addSuppressed(t2);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
