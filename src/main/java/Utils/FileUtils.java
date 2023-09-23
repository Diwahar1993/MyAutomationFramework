package Utils;

import java.io.File;

public class FileUtils {
    public static void deleteFolderContents(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If it's a subdirectory, recursively delete its contents
                    deleteFolderContents(file);
                } else {
                    // If it's a file, delete it
                    if (file.delete()) {
                        System.out.println("Deleted file: " + file.getAbsolutePath());
                    } else {
                        System.err.println("Failed to delete file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
