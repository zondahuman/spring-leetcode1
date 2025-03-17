package com.abin.lee.test.algo.leetcode.temp;
import java.io.File;

public class RenameMarch {

    public static void main(String[] args) {
        // 指定要查找的目录路径
        String directoryPath = "/Users/lee/work"; // 请替换为你的实际目录路径

        // 使用File类表示目录
        File directory = new File(directoryPath);
        // 检查目录是否存在
        if (directory.exists() && directory.isDirectory()) {
            // 获取目录下的所有文件和子目录
            File[] files = directory.listFiles();

            // 遍历获取到的文件和子目录
            if (files != null) {
                for (File file : files) {
                    // 检查是否为文件
                    if (file.isFile()) {
                        // 打印文件路径
                        System.out.println("Found file: " + file.getAbsolutePath());
                        System.out.println("Found file name: " + file.getName());
                        // 你可以在这里添加更多逻辑来处理找到的文件
                    }
                }
            } else {
                System.out.println("The directory is empty or an error occurred.");
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }


}
