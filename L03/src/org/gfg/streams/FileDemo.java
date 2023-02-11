package org.gfg.streams;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/tmp/testFile.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.canRead());
        System.out.println(file.canExecute());
        File dir = new File("/tmp");
        System.out.println(dir.isDirectory());
        System.out.println(dir.isFile());
    }
}
