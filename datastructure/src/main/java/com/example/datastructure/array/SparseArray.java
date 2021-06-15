package com.example.datastructure.array;


/**
 * 稀疏数组
 * row  clo  val
 * 0  11   11    2
 * 1  1    2     1
 * 2  2    3     2
 * <p>
 * 第一行：
 * [0][0] :第一行第一列 记录原始数组 行数
 * [0][1] :原始数组 列数
 * [0][2] :原始数组有多少个有效数据 （非0）
 * <p>
 * 之后的行记录原始数据 详情 eg:
 * [1][0] ：第二行第一列 记录第一个有效数据的再原始数组中 行的位置
 * [1][1] ：第二行第二列 记录 列的位置
 * [1][2] : 第二行第三列 记录 原始数据值
 */
public class SparseArray {
    public static void main(String[] args) {
        // 1. 创建一个原始的二维数组 11*11
        // 0:没棋子 1：黑子 2:蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        //输出原始的二维数组
        printArr(chessArr1);

        //
        /**
         * 二维数组转 稀疏数组
         * 1. 遍历 原始的二维数组，得到有效数组的个数 sum
         * 2. 根据sum 就可以创建稀疏数组 sparseArr int[sum+1][3]
         * 3. 将二维数组的有效数组存入到稀疏数组中
         */
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (row[j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        //输出稀疏数组
        for (int[] row : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }


        /**
         * 稀疏数组恢复 原始的二维数组
         * 1. 先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组 ，eg:chessArr2=ini[11][11]
         * 2. 再读取稀疏数组后几行的数据，并赋值给原始的二维数组即可
         */
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]]; //int [11][11]
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        printArr(chessArr2);

    }



    private static void printArr(int[][] chessArr2) {
        for (int[] row : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }


}
