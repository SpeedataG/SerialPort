package com.spd.hardware;

import android.text.TextUtils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author :Reginer  2023/3/28 0028 10:18.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
public class SerialPortUtil {
    /**
     * Hex string to bytes.
     * <p>e.g. hexString2Bytes("00A8") returns { 0, (byte) 0xA8 }</p>
     *
     * @param hexString The hex string.
     * @return the bytes
     */
    public static byte[] hexString2Bytes(String hexString) {
        if (TextUtils.isEmpty(hexString)) {
            return new byte[0];
        }
        int len = hexString.length();
        if (len % 2 != 0) {
            hexString = "0" + hexString;
            len = len + 1;
        }
        char[] hexBytes = hexString.toUpperCase().toCharArray();
        byte[] ret = new byte[len >> 1];
        for (int i = 0; i < len; i += 2) {
            ret[i >> 1] = (byte) (hex2Dec(hexBytes[i]) << 4 | hex2Dec(hexBytes[i + 1]));
        }
        return ret;
    }

    private static int hex2Dec(final char hexChar) {
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0';
        } else if (hexChar >= 'A' && hexChar <= 'F') {
            return hexChar - 'A' + 10;
        } else {
            throw new IllegalArgumentException();
        }
    }



    /**
     * Return the lines in file.
     *
     * @param filePath The path of file.
     * @return the lines in file
     */
    @SuppressWarnings("")
    public static List<String> readFile2List(final String filePath) {
        File currentFile = new File(filePath);
        if (!currentFile.exists()) {
            return null;
        }
        BufferedReader reader = null;
        try {
            String line;
            int curLine = 1;
            List<String> list = new ArrayList<>();

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile)));

            while ((line = reader.readLine()) != null) {
                if (0 <= curLine) {
                    list.add(line);
                }
                ++curLine;
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Return the files that satisfy the filter in directory.
     * <p>Doesn't traverse subdirectories</p>
     *
     * @param dirPath The path of directory.
     * @param filter  The filter.
     * @return the files that satisfy the filter in directory
     */
    public static List<File> listFilesInDirWithFilter(final String dirPath, final FileFilter filter) {
        File dir = new File(dirPath);
        List<File> list = new ArrayList<>();
        if (!isDir(dir)) return list;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (filter.accept(file)) {
                    list.add(file);
                }
            }
        }
        return list;

    }

    /**
     * Return whether it is a directory.
     *
     * @param file The file.
     * @return {@code true}: yes<br>{@code false}: no
     */
    private static boolean isDir(final File file) {
        return file != null && file.exists() && file.isDirectory();
    }
}
