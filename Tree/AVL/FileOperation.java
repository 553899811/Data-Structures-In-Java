package com.zhangyong.DataStructures.Tree.AVL;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 * @date 2020/1/26 17:04
 */
public class FileOperation {
    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null OR words is null");
            return false;
        }
        Scanner scanner = null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(inputStream), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Cannot open " + filename);
            e.printStackTrace();
        }
        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }
}