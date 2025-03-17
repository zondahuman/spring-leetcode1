package com.abin.lee.test.algo.leetcode.temp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenameMarch {

    public static void main(String[] args) {
        // 指定要查找的目录路径
        String directoryPath = "/Users/lee/jiujiu/DIYrec"; // 请替换为你的实际目录路径
        String newDirectoryPath = "/Users/lee/jiujiu/newDIYrec/"; // 请替换为你的实际目录路径

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
                        String newFileName = "0"+file.getName();
//                        File newFile = new File(newDirectoryPath + newFileName);
                        // 打印文件路径
                        System.out.println("Found file AbsolutePath: " + file.getAbsolutePath());
//                        System.out.println("Found file name: " + file.getName());
                        // 你可以在这里添加更多逻辑来处理找到的文件
                        // 4. 检查重命名操作是否成功
                        Path sourcePath = Paths.get(file.getAbsolutePath());
                        Path destinationPath = Paths.get(newDirectoryPath + newFileName);

                        try {
                            Files.copy(sourcePath, destinationPath);
                            System.out.println("文件复制成功！源文件为:"+sourcePath.toString()+",修改后的文件为："+destinationPath.toString());
                        } catch (IOException e) {
                            System.err.println("文件复制失败：" + e.getMessage());
                        }
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
