package com.lhy.adminj.basic.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数学计算类工具
 * User: D.D
 * Date: 13-7-3
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
public class MathUtil {

    /**
     * 几何平均
     * @param inputList
     * @return
     */
    public static Double getGeometricMean(List<Double> inputList){
        Double p = getProduct(inputList);
        Double v = Math.pow(Math.E, Math.log(p)/inputList.size());
        if(v.isInfinite() || v.isNaN()){
            try {
                System.out.println(inputList.toString());
                throw new Exception("isNaN or isInfinite");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return v;
    }

    /**
     * 累乘
     * @param inputList
     * @return
     */
    public static Double getProduct(List<Double> inputList){
        if(inputList == null || inputList.size() == 0) return null;
        Double s = null;
        for(Double input : inputList){
            if(input == null){
                continue;
            }
            if (s == null) {
                s = input;
            } else {
                s = s * input;
            }
        }
        return s;
    }

    /**
     * 计算波动率
     * @param list
     * @return
     */
    public static Double getVolatility(List<Double> list){
        if(list.size() < 2) return 0d;
        List<Double> list2 = new ArrayList<Double>();
        for(int i = 1; i < list.size(); i++){
            list2.add(list.get(i) / list.get(i - 1) -1);
        }
        return MathUtil.getStd(list2);
    }

    /**
     * 计算方差
     *
     * @param inputList
     * @return
     */
    public static Double getVariance(List<Double> inputList) {
        if (inputList.size() <= 0) {
            return 0d;
        }
        Double average = getAverageDouble(inputList);
        Double sum = 0d;
        for (Double input : inputList) {
            if (input == null) {
                continue;
            }
            sum += Math.pow(input - average, 2);
        }
        return sum / (double) inputList.size();
    }

    /**
     * 计算标准差
     *
     * @param inputList
     * @return
     */
    public static Double getStd(List<Double> inputList) {
        return Math.pow(MathUtil.getVariance(inputList), 0.5d);
    }

    public static void main(String args[]){
        Double[] ds = new Double[]{35.7496, 35.5582, 35.0606, 35.673, 35.8261, 34.7162, 35.0606, 33.4913, 32.2665, 32.9937, 33.2234, 32.9555, 33.1086, 33.4148, 32.3431, 32.3048, 31.922, 31.9603, 32.6493, 33.6062, 34.0272, 32.8789, 33.9506, 34.2568, 35.3286, 35.2903, 36.2089, 34.8693, 35.8644, 35.2137, 35.52, 34.5248, 34.7162, 36.6682, 36.4386, 35.4817, 36.5151, 36.4769, 36.2855, 35.52, 35.2903, 34.831, 34.142, 35.0606, 35.252, 34.4482, 35.0989, 34.4865, 34.4099, 35.7113, 35.4792, 35.0923, 34.8988, 35.0923, 35.7113, 36.6012, 36.2917, 36.3304, 35.0923, 34.9762, 34.7054, 34.5893, 34.9375, 36.0982, 36.6399, 36.6399, 35.8661, 35.3244, 35.7113, 34.7054, 34.4345, 33.9703, 32.4613, 33.1965, 33.0417, 32.6161, 32.9643, 32.8096, 33.1578, 33.1965, 32.8482, 33.9316, 33.1191, 31.4941, 31.3006, 31.7262, 31.6101, 30.3334, 30.6429, 30.256, 30.2947, 29.9465, 29.4048, 29.8691, 29.3274, 29.1727, 29.1727, 29.1727, 28.9792, 29.4822, 28.4375, 28.7858, 29.25, 29.3661, 29.3274, 29.753, 29.25, 28.128, 28.0893, 27.9733, 28.0893, 28.0506, 27.509, 27.625, 27.0834, 27.1221, 27.2381, 26.5804, 26.5417, 26.0774, 26.2709, 26.3869, 26.9286, 26.4256, 26.5417, 26.9286, 27.7798, 27.9346, 27.7024, 27.8572, 27.5476, 27.4316, 26.3096, 26.2322, 26.2709, 25.7679, 25.6518, 25.8066, 25.8066, 25.4584, 26.0774, 26.6191, 26.1935, 27.1221, 27.1608, 26.8512, 26.8512, 26.7739, 27.1608, 26.8899, 27.7798, 27.9346, 27.9733, 28.012, 27.8959, 27.5477, 26.8899, 26.6191, 26.8126, 27.006, 28.7084, 29.0953, 28.9018, 28.631, 28.4763, 28.4376, 28.3209, 29.1721, 27.6245, 27.5471, 27.315, 27.315, 27.1989, 27.1989, 27.818, 27.5471, 27.934, 27.5472, 26.7347, 26.6573, 26.5025, 27.315, 27.1216, 27.6245, 28.8239, 28.7852, 29.2495, 29.443, 29.0948, 29.3269, 29.1335, 30.7197, 30.6037, 29.7525, 29.7912, 30.1007, 29.6364, 29.7525, 31.3001, 31.4162, 30.7584, 31.7257, 32.8864, 33.3507, 34.0471, 33.7763, 33.1572, 33.428, 31.9191, 32.9637, 33.0798, 32.2286, 32.1512, 33.3893, 33.0024, 32.4994, 32.5381, 31.8804, 31.4935, 32.6542, 32.6155, 33.5441, 31.9191, 32.1125, 31.4548, 32.422, 31.6869, 31.5322, 32.6155, 32.5381, 31.4548, 31.7643, 30.681, 30.7584, 30.5649, 29.6751, 29.9846, 30.681, 30.1781, 27.1989, 27.5085, 27.6245, 27.7406, 27.4698, 27.6245, 27.315, 27.1989, 27.2376, 27.2763, 27.1215, 27.5858, 28.1275, 27.8566, 27.9727, 27.9727, 28.0114, 27.9727, 27.1215, 27.2376, 27.5858, 27.7406, 27.5858, 27.8179, 28.3983, 27.934, 27.7019, 27.4697, 27.2376, 28.0114, 27.8953, 27.8566, 28.0887, 27.2762, 27.6244, 27.3536, 27.1989, 27.3923, 28.1661, 28.2048, 28.2435, 28.3209, 27.6632, 27.4698, 27.6632, 28.3983, 29.0947, 28.8239, 29.4816, 29.7138, 28.94, 29.056, 29.1334, 29.8685, 29.2882, 29.4042, 28.6691, 28.7078, 28.2049, 27.7406, 26.9281, 27.0055, 26.6573, 26.696, 26.5412, 25.8448, 25.7674, 23.1752, 22.5561, 22.5948, 22.827, 23.5234};
        List<Double> list = Arrays.asList(ds);
        System.out.print(getStd(list));
    }

    /**
     * 计算平均数
     *
     * @param inputList
     * @return
     */
    public static Double getAverageDouble(List<Double> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return 0d;
        }
        Double average = 0d;
        for (Double input : inputList) {
            if (input == null) {
                continue;
            }
            average += input;
        }
        return average / (double) inputList.size();
    }

    /**
     * 计算平均数
     *
     * @param inputList
     * @return
     */
    public static Double getAverageInteger(List<Integer> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return 0d;
        }
        Integer average = 0;
        for (Integer input : inputList) {
            if (input == null) {
                continue;
            }
            average += input;
        }
        return average.doubleValue() / (double) inputList.size();
    }

    /**
     * 计算和
     *
     * @param inputList
     * @return
     */
    public static Double getSumDouble(List<Double> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return 0d;
        }
        Double sum = 0d;
        for (Double input : inputList) {
            if (input == null) {
                continue;
            }
            sum += input;
        }
        return sum;
    }

    private static Double getSumInteger(List<Integer> inputList){
        if (inputList == null || inputList.size() <= 0) {
            return 0d;
        }
        Integer sum = 0;
        for (Integer input : inputList) {
            if (input == null) {
                continue;
            }
            sum += input;
        }
        return sum.doubleValue();
    }


    /**
     * 计算最小值
     *
     * @param inputList
     * @return
     */
    public static Double getMinDouble(List<Double> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return null;
        }
        Double min = null;
        for (Double input : inputList) {
            if (input == null) {
                continue;
            }
            if (min == null) {
                min = input;
            } else {
                if (min > input) {
                    min = input;
                }
            }
        }
        return min;
    }


    /**
     * 计算最小值
     *
     * @param inputList
     * @return
     */
    public static Integer getMinInteger(List<Integer> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return null;
        }
        Integer min = null;
        for (Integer input : inputList) {
            if (input == null) {
                continue;
            }
            if (min == null) {
                min = input;
            } else {
                if (min > input) {
                    min = input;
                }
            }
        }
        return min;
    }


    /**
     * 计算最大值
     *
     * @param inputList
     * @return
     */
    public static Integer getMaxInteger(List<Integer> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return null;
        }
        Integer max = null;
        for (Integer input : inputList) {
            if (input == null) {
                continue;
            }
            if (max == null) {
                max = input;
            } else {
                if (max < input) {
                    max = input;
                }
            }
        }
        return max;
    }


    /**
     * 计算最大值
     *
     * @param inputList
     * @return
     */
    public static Double getMaxDouble(List<Double> inputList) {
        if (inputList == null || inputList.size() <= 0) {
            return null;
        }
        Double max = null;
        for (Double input : inputList) {
            if (input == null) {
                continue;
            }
            if (max == null) {
                max = input;
            } else {
                if (max < input) {
                    max = input;
                }
            }
        }
        return max;
    }

    /**
     * 加法
     * @param d1
     * @param d2
     * @return
     */
    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘法
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 除法
     * @param d1
     * @param d2
     * @return
     */
    public static double div(double d1, double d2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 对比
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equal(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.equals(b2);
    }

    /**
     * 小数位四舍五入处理
     * @param d
     * @param scale
     * @return
     */
    public static double round(double d, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(d));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
