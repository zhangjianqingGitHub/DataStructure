package com.example.datastructure.recursion;

// 迷宫回溯问题
public class MiGong {
    public static void main(String[] args) {
        //二维数组，模拟迷宫
        int[][] map = new int[8][7];

        //用1表示墙，造墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        //输出
        print(map);

        setWay(map, 1, 1);
        System.out.println();
        print(map);
    }

    private static void print(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 从（1，1）开始走，到了(6，5)的位置说明出去了
     * 0 表示没走过，1表示墙，2表示通路可以走，3表示已经走过但是走不通
     * 策略：下->右->上->左
     *
     * @param map 表示地图
     * @param i   从那个位置找
     * @param j   从那个位置找
     * @return 找到返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {

            if (map[i][j] == 0) {
                //如果当前这个点还没有走过，按照策略走
                map[i][j] = 2;//假定这个点可以走通
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通
                    map[i][j] = 3;
                }
            } else {
                //map！=0;可能是 1，2，3
                return false;
            }

        }
        return false;
    }
}
