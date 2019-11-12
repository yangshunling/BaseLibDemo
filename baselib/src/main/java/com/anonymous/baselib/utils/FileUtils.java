package com.anonymous.baselib.utils;

import android.annotation.SuppressLint;
import android.util.Base64;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: FileUtils
 * @Author: Anonymous
 * @Time: 2019/8/31 19:05
 */
public class FileUtils {
    /**
     * 将文件转成base64字符串
     *
     * @param path 文件路径
     */
    @SuppressLint("NewApi")
    public static String getBase64FromFile(String path) {
        File file = new File(path);
        FileInputStream inputFile = null;
        byte[] buffer = new byte[(int) file.length()];
        try {
            inputFile = new FileInputStream(file);
            inputFile.read(buffer);
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(buffer, Base64.DEFAULT);
    }

    /**
     * 将String数据存为文件
     *
     * @param content
     * @param path
     * @return
     */
    public static String getFileFromString(String content, String path) {
        byte[] b = content.getBytes();
        BufferedOutputStream stream = null;
        FileOutputStream fstream = null;
        File file = null;
        try {
            file = new File(path);
            fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return path;
    }

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getByteFromFile(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 将byte转成文件
     *
     * @param bytes
     * @param path
     * @return
     */
    public static String getFileFromByte(byte[] bytes, String path) {
        BufferedOutputStream stream = null;
        FileOutputStream fstream = null;
        File file = null;
        try {
            file = new File(path);
            fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return path;
    }

    //byte[]转base64
    @SuppressLint("NewApi")
    public static String getBase64FromByte(byte[] buffer){
        return Base64.encodeToString(buffer, Base64.DEFAULT);
    }

}
