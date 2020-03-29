package com.jiayou.algorithms;


import com.sun.org.apache.xerces.internal.xs.StringList;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

/**
 * Create by fz on 2020/3/23
 */
public class ChessArray {
    public static void main(String[] args) {
        //创建棋盘
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        printArray(chessArray1);

        //确定有效个数
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                }
            }
        }
        //保存到稀疏数组
        int[][] parseArray = new int[count + 1][3];

        parseArray[0][0] = chessArray1.length;
        parseArray[0][1] = chessArray1[0].length;
        parseArray[0][2] = count;

        int index = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[1].length; j++) {
                int value = chessArray1[i][j];
                if (value != 0) {
                    index++;
                    parseArray[index][0] = i;
                    parseArray[index][1] = j;
                    parseArray[index][2] = value;
                }
            }

        }

        System.out.println("稀疏数组为：");
        printArray(parseArray);

        //创建输出流
        try {
            FileWriter writer = new FileWriter("src\\parseArray");
            for (int i = 0; i < parseArray.length; i++) {
                writer.write(parseArray[i][0] + " " + parseArray[i][1] + " " + parseArray[i][2] + "\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从文件读取稀疏数组
        //创建输入流
        BufferedReader reader = null;
        ArrayList<String> stringlist = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src\\parseArray"));
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                stringlist.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //将读取到的string转换为稀疏数组int[][]
        int[][] parseArray2 = new int[stringlist.size()][3];
        int index1 = 0;
        for (String s : stringlist) {

            String[] split = s.split(" ");
            //插入到稀疏数组中
            parseArray2[index1][0] = Integer.parseInt(split[0]);
            parseArray2[index1][1] = Integer.parseInt(split[1]);
            parseArray2[index1][2] = Integer.parseInt(split[2]);
            index1++;
        }
//        System.out.println("读取的稀疏数组打印:");
//        printArray(parseArray2);

        //将稀疏数组还原为棋盘
        int[][] chessMap1 = new int[parseArray2[0][0]][parseArray2[0][1]];
//        printArray(chessMap1);

        //将有效值写盘
        for (int i = 1; i < parseArray2.length; i++) {
            int row = parseArray2[i][0];
            int col = parseArray2[i][1];
            int value = parseArray2[i][2];
            chessMap1[row][col] = value;
        }

        //还原棋盘
        printArray(chessMap1);

        //关闭资源
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
