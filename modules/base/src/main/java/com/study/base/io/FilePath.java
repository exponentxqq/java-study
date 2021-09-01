package com.study.base.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilePath {
  private static final String ROOT = "." + java.io.File.separator;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(java.io.File.separator);
    System.out.println(java.io.File.pathSeparator);
    System.out.println("当前路径->" + ROOT);
    java.io.File dir = createDirs();
    System.out.println("创建的文件夹路径：" + dir.getAbsoluteFile());
    java.io.File newDir = renameDir(dir);
    if (newDir != null) {
      System.out.println("重命名后的文件夹路径：" + newDir.getAbsoluteFile());
    }
  }

  private static java.io.File createDirs() {
    List<String> pathList = new ArrayList<>();
    while (true) {
      System.out.println("请输入文件路径，如果为空程序将结束");
      String path = scanner.nextLine();
      if (path.isBlank()) {
        break;
      }
      pathList.add(path);
    }
    // java范型是类型擦除的。想要一个String类型的数组，但是在运行时并不能得到List的范型类型
    return createDir(pathList.toArray(new String[0]));
  }

  private static java.io.File createDir(String... restPaths) {
    String rest = joinRestDir(restPaths);
    System.out.println("将在" + ROOT + "下创建" + rest);
    java.io.File dir = new java.io.File(ROOT, rest);
    if (dir.exists() && dir.isDirectory()) {
      System.out.println("文件夹已存在" + dir.toString());
      return dir;
    } else {
      boolean created = dir.mkdirs();
      if (created) {
        return dir;
      } else {
        throw new IllegalArgumentException("无法在" + ROOT + "下创建" + rest);
      }
    }
  }

  private static String joinRestDir(String... restPaths) {
    return Arrays.stream(restPaths)
        .map(String::trim)
        .collect(Collectors.joining(java.io.File.separator));
  }

  private static java.io.File renameDir(java.io.File dir) {
    System.out.println("请输入新的文件夹名称");
    String newDirName = scanner.nextLine().trim();

    java.io.File newDir = new java.io.File(dir.getParentFile(), newDirName);
    boolean renamed = dir.renameTo(newDir);

    if (renamed) {
      System.out.println("改名为" + newDirName + "成功");
      return newDir;
    } else {
      System.out.println("改名为" + newDirName + "失败");
      return null;
    }
  }

  private static String createFiles(java.io.File newDir) throws IOException {
    System.out.println("请输入文件名");
    String filename = scanner.nextLine();
    for (int i = 0; i < 20; i++) {
      java.io.File file = new java.io.File(newDir, filename + i + ".txt");
      System.out.println("创建文件" + file.getName() + ": " + file.createNewFile());
    }
    return filename;
  }

  private static String renameFiles(java.io.File newDir, String filename) {
    System.out.println("请输入新的文件名");
    String newFilename = scanner.nextLine();
    for (int i = 0; i < 20; i++) {
      java.io.File file = new java.io.File(newDir, filename + i + ".txt");
      java.io.File newFile = new java.io.File(newDir, newFilename + i + ".txt");
      System.out.println("重命名文件：" + file.getName() + ": " + file.renameTo(newFile));
    }
    return newFilename;
  }

  private static void deleteFiles(java.io.File newDir, String newFilename) {
    System.out.println("删除文件？");
    boolean isDelete = scanner.nextBoolean();
    if (isDelete) {
      for (int i = 0; i < 20; i++) {
        java.io.File newFile = new java.io.File(newDir, newFilename + i + ".txt");
        System.out.println("删除文件：" + newFile.delete());
      }
    }
  }
}
