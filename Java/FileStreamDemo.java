package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileStreamDemo {

    private static final String folderPath = "C:/Users/POT31166/Documents/core-java/resources";

    public static void main(String[] args) throws IOException {

        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean mkdirs = folder.mkdirs();
            System.out.println("Created a folder: " + folderPath);
        }
        File src = new File(folderPath, "/example.txt");
        File dest = new File(folderPath, "/example-copy.txt");
        /*
         * try(FileReader fr = new FileReader(folder + "/example.txt"); FileWriter fw =
         * new FileWriter(folder+"/example.txt")) {
         * fw.write("Hello I'm writing this content to example file");
         * fw.flush();
         * System.out.println("Reading with FileReader");
         * StringBuilder sb = new StringBuilder();
         * int ch;
         * while((ch = fr.read()) != -1) {
         * sb.append((char)ch);
         * }
         * System.out.println("Content: "+ sb.toString());
         * }
         */
            copyCharacters(src, dest);
        if (dest.exists()) {
            System.out.println("Exists, Delete");
            copyByte(src, dest);    
        }

         if (dest.exists()) {
            System.out.println("Exists, Delete");
            copyFileWithBuffer(src, dest);    
        }
        
        if (dest.exists()) {
            System.out.println("Exists, Delete");
            copyTextFileWithBuffer(src, dest);
        }
    }

    static void copyCharacters(File src, File dest) throws IOException {
        System.out.println("copyCharacters");
        try (var reader = new FileReader(src);
                var writer = new FileWriter(dest)) {
            int b;
            while ((b = reader.read()) != -1) {
                writer.write(b);
            }

        }  
    }

      static void copyByte(File src, File dest) throws IOException {
        System.out.println("copyByte");
        try (var reader = new FileInputStream(src);
                var writer = new FileOutputStream(dest)) {
            int b;
            while ((b = reader.read()) != -1) {
                writer.write(b);
            }

        }  
    }

    static void copyFileWithBuffer(File src, File dest) throws IOException {
        System.out.println("copyFileWithBuffer");
        try (var in = new BufferedInputStream(
                new FileInputStream(src));
                var out = new BufferedOutputStream(
                        new FileOutputStream(dest))) {
            var buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }
    //Method copying one line at a time
    static void copyTextFileWithBuffer(File src, File dest) throws IOException {
        System.out.println("copyTextFileWithBuffer");
        try (var reader = new BufferedReader(new FileReader(src));
                var writer = new BufferedWriter(new FileWriter(dest))) {
            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
            }
        }
    }
}