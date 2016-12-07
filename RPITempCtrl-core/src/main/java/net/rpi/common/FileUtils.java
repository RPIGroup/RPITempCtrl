/*******************************************************************************
 *
 * 文件名：FileUtil.java
 * 功能：实现文件操作集合
 * 开发语言： JAVA语言
 * 开发环境：Eclipse 3.5版
 * 硬件支持：无
 * 作者：    毛宝龙
 * 初始创作日期：2010-10-16
 *
 * 版本：1.0 版
 *
 * 如有问题请联系:
 * maobaolong@139.com
 * @pt
 *******************************************************************************/

package net.rpi.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.charset.Charset;




public class FileUtils {

    /**
     * 文件转换为字节数组
     *
     * @param fileName
     *            文件路径
     * @return 文件的字节数组
     * @throws FileNotFoundException
     */
    public static byte[] getFileByte(String fileName)
            throws FileNotFoundException {
        // 把文件封装成文件输入流类型对象
        FileInputStream fileInputStream = new FileInputStream(fileName);
        return getFileByte(fileInputStream);
    }

    /**
     * 文件转换为字节数组
     *
     * @param url
     *            文件路径URL
     * @return 文件的字节数组
     * @throws IOException
     */
    public byte[] getFileByte(URL url) throws IOException {
        if (url != null) {
            // 获得URL对应的输入流
            return getFileByte(url.openStream());
        } else {
            return null;
        }
    }

    /**
     * 输入流文件转换为字节数组
     *
     * @param in
     *            输入流
     * @return 字节数组
     */
    private static byte[] getFileByte(InputStream in) {

        return getFileByteArrayOutputStream(in).toByteArray();

    }
    public static ByteArrayOutputStream getFileByteArrayOutputStream(InputStream in) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
        try {
            // 把输入流复制到输出流
            copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;

    }
    /**
     * 向制定文件追加数据
     *
     * @param path
     *            路径
     * @param data
     *            数据
     */
    public static void appendFile(String path, byte[] data) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(path, "rw");
            randomAccessFile.skipBytes((int) randomAccessFile.length());
            randomAccessFile.write(data, 0, data.length);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 从输入流拷贝到输出流
     *
     * @param in
     *            输入流
     * @param out
     *            输出流
     * @throws IOException
     */
    private static void copy(InputStream in, OutputStream out)
            throws IOException {

        try {
            byte[] buffer = new byte[4096];
            int nrOfBytes = -1;
            // 以4096为单位，去读缓冲区，不出错的额情况下，就写到缓冲区
            while ((nrOfBytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, nrOfBytes);
            }
            // 冲缓冲区
            out.flush();
        } catch (IOException e) {

        } finally {
            try {
                // 关闭输入流
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
            try {
                // 关闭输出流
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
            }
        }

    }

    /**
     * 移动目录 - 将目录src本身及所有子文件、文件夹移动到dest目录下
     *
     * @author mbl
     * @param src
     *            String 如 c:/fqf
     * @param dest
     *            String 如 c:/fqf
     * @return void
     */
    public static void moveFolder(String src, String dest) {
        File srcFolder = new File(src);
        File destFolder = new File(dest);
        File newFile = new File(destFolder.getAbsoluteFile() + "\\"
                + srcFolder.getName());
        srcFolder.renameTo(newFile);
    }

    /**
     * 新建目录
     *
     * @param folderPath
     *            String 如 c:/fqf
     * @return boolean
     */
    public static void createFolder(String folderPath) {
        if (folderPath == null) {
            return;
        }
        String filePath = folderPath;
        filePath = filePath.toString();
        java.io.File myFilePath = new java.io.File(filePath);
        if (!myFilePath.exists()) {
            myFilePath.mkdir();
        }

    }

    /**
     * 新建文件
     *
     * @param filePathAndName
     *            String 文件路径及名称 如c:/fqf.txt
     * @param fileContent
     *            String 文件内容
     * @return boolean
     */
    public static void createFile(String filePathAndName, String fileContent) {
        if (filePathAndName == null || fileContent == null)
            return;
        try {
            String filePath = filePathAndName;
            File myFilePath = new File(filePath);
            if(!myFilePath.getParentFile().exists()){
                myFilePath.getParentFile().mkdirs();
            }
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            String strContent = fileContent;
            myFile.print(strContent);
            resultFile.close();

        } catch (IOException e) {
            System.out.println("新建目录操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 创建文件
     * @param filePathAndName 文件路径
     * @param fileContent 文件内容
     */
    public static void createFile(String filePathAndName, byte[] fileContent) {
        try {
            FileOutputStream fos = new FileOutputStream(filePathAndName);// 把刚读出的数据储存在本地的bin文件
            if (fileContent != null)
                fos.write(fileContent);
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 删除文件
     *
     * @param filePathAndName
     *            String 文件路径及名称 如c:/fqf.txt
     * @return 是否成功删除
     */
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();

        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 删除文件夹
     *
     * @param folderPath
     *            文件夹路径及名称 如c:/fqf
     * @return 是否成功删除
     */
    public static boolean delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); // 删除空文件夹

        } catch (Exception e) {
            System.out.println("删除文件夹操作出错");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除文件夹里面的所有文件
     *
     * @param path
     *            文件夹路径 如 c:/fqf
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + File.separator + tempList[i]);// 先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
            }
        }
    }

    public static void delAllFileWithExt( String path,String ext) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()&&tempList[i].endsWith(ext)) {
                temp.delete();
            }

        }
    }

    public static int getFileCount(String path) {
        int count = 0;
        File file = new File(path);
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return 0;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                count++;
            }
            if (temp.isDirectory()) {
                count += getFileCount(path + "/" + tempList[i]);// 先删除文件夹里面的文件
            }
        }
        return count;
    }
    public static int getFileCountWithExt(String path,String ext) {
        int count = 0;
        File file = new File(path);
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return 0;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()&&tempList[i].endsWith(ext)) {
                count++;
            }

        }
        return count;
    }


    /**
     * 复制单个文件
     *
     * @param oldPath
     *            原文件路径 如：c:/fqf.txt
     * @param newPath
     *            复制后路径 如：f:/fqf.txt
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (IOException e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath
     *            原文件路径 如：c:/fqf
     * @param newPath
     *            复制后路径 如：f:/fqf/ff
     * @return 是否成功
     */
    public static boolean copyFolder(String oldPath, String newPath) {
        if (oldPath == null || newPath == null)
            return false;
        try {
            (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath
                            + "/" + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {// 如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 移动文件
     * @param oldPath 原位置
     * @param newPath 目的位置
     */
    public static void moveTo(String oldPath, String newPath) {
        copyFile(oldPath, newPath);
        delFile(oldPath);
    }

    /**
     * 读文件
     * @param strFileName 文件位置
     * @return 文件内容
     */
    public static String readFile(String strFileName) {
        StringBuffer buf = null;
        BufferedReader breader = null;
        buf = new StringBuffer();
        try {
            breader = new BufferedReader(new InputStreamReader(
                    new FileInputStream((strFileName)), Charset.forName("GBK")));
            while (breader.ready())
                buf.append((char) breader.read());
            breader.close();
        } catch (FileNotFoundException fnfe)// FileNotFoundException异常是IOException的一种
        {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
    public static void visitFile(String folder,IVisitor visitor){
        File f = new File(folder);
        if(f.isDirectory()&&f.exists()){
            File[] files = f.listFiles();
            for(File file:files){
                if(file.isDirectory()){
                    visitFile(file.getPath(),visitor);
                }else{
                    visitor.visit(file.getPath());
                }
            }
        }
    }
    public interface IVisitor {
        public void visit(String filenName);
    }

    public static boolean isFileExsit(String path){
        return new File(path).exists();
    }

}
