// /////////////////////
// Cleaning Up Resources
// /////////////////////

public String readFile(String filePath) throws IOException {
  FileInputStream fileStream = null;
  StringBuilder contents = new StringBuilder();
  byte[] buffer = new byte[4096];
  try {
    fileStream = new FileInputStream(filePath);
    while (fileStream.read(buffer) != -1) {
      contents.append(new String(buffer));
    }
  } finally {
    if (fileStream != null) {
      fileStream.close();
    }
  }
  return contents.toString();
}
