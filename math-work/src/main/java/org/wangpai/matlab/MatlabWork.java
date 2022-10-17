package org.wangpai.matlab;

import MatlabUtil.MatlabUtil;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWComplexity;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class MatlabWork {
    public final static double PI = 3.1415926;

    /**
     * 双曲螺线
     *
     * @since 2022-10-16
     */
    public static void hyperbolicSpiral() throws MWException {
        final long startTime = System.currentTimeMillis();
        double start = PI;
        double end = 1000 * PI;
        double interval = PI / 100;
        int pointNum = (int) ((end - start) / interval);
        int[] dimensions = {1, pointNum};
        MWNumericArray x = MWNumericArray.newInstance(dimensions, MWClassID.DOUBLE, MWComplexity.REAL);
        MWNumericArray y = MWNumericArray.newInstance(dimensions, MWClassID.DOUBLE, MWComplexity.REAL);
        final double c = 100;
        for (int i = 1; i <= pointNum; ++i) {
            double ti = i * interval + start;
            double xi = c * cos(ti) / ti;
            x.set(i, xi);
            double yi = c * sin(ti) / ti;
            y.set(i, yi);
        }
        MatlabUtil matlabUtil = null;
        try {
            matlabUtil = new MatlabUtil();
            matlabUtil.matlabPlot(x, y); // 在 MATLAB 绘制完图像界面之后，此方法会返回
            System.out.printf("双曲螺线绘制用时：%fs%n", (System.currentTimeMillis() - startTime) / 1000.0);
            matlabUtil.waitForFigures(); // 在用户关闭 MATLAB 图像界面之前，此方法会阻塞当前线程
        } finally {
            // 释放 MATLAB 图像界面资源。一旦释放之后，当前 MATLAB 图像界面会被迫关闭
            MWArray.disposeArray(x);
            MWArray.disposeArray(y);
            if (matlabUtil != null) {
                matlabUtil.dispose();
            }
        }
    }

    /**
     * 蝴蝶曲线
     *
     * @since 2022-10-16
     */
    public static void butterflyCurve() throws MWException {
        final long startTime = System.currentTimeMillis();
        double start = 0;
        double end = 20 * PI;
        double interval = PI / 50;
        int pointNum = (int) ((end - start) / interval);
        int[] dimensions = {1, pointNum};
        MWNumericArray x = MWNumericArray.newInstance(dimensions, MWClassID.DOUBLE, MWComplexity.REAL);
        MWNumericArray y = MWNumericArray.newInstance(dimensions, MWClassID.DOUBLE, MWComplexity.REAL);
        for (int i = 1; i <= pointNum; ++i) {
            double xi = i * interval + start;
            x.set(i, xi);
            double yi = exp(cos(xi - PI / 2)) - 2 * cos(4 * (xi - PI / 2)) + pow(sin((xi - PI / 2) / 12), 5);
            y.set(i, yi);
        }
        MatlabUtil matlabUtil = null;
        try {
            matlabUtil = new MatlabUtil();
            matlabUtil.matlabPolarplot(x, y); // 在 MATLAB 绘制完图像界面之后，此方法会返回
            System.out.printf("蝴蝶曲线绘制用时：%fs%n", (System.currentTimeMillis() - startTime) / 1000.0);
            matlabUtil.waitForFigures(); // 在用户关闭 MATLAB 图像界面之前，此方法会阻塞当前线程
        } finally {
            // 释放 MATLAB 图像界面资源。一旦释放之后，当前 MATLAB 图像界面会被迫关闭
            MWArray.disposeArray(x);
            MWArray.disposeArray(y);
            if (matlabUtil != null) {
                matlabUtil.dispose();
            }
        }
    }
}
