package org.wangpai.matlab;

import com.mathworks.toolbox.javabuilder.MWException;
import org.junit.jupiter.api.Test;

class MatlabWorkTest {

    @Test
    void javaVersion() {
        System.out.println("Java 版本号：" + System.getProperty("java.version"));
        System.out.println("Java 虚拟机规范版本号：" + System.getProperty("java.vm.specification.version"));
        System.out.println("Java 规范版本号：" + System.getProperty("java.specification.version"));
        System.out.println("Java 类路径：" + System.getProperty("java.class.path"));
        System.out.println("Java lib 路径：" + System.getProperty("java.library.path"));
        System.out.println("Java 执行路径：" + System.getProperty("java.ext.dirs"));
    }

    @Test
    void hyperbolicSpiral() throws MWException {
        MatlabWork.hyperbolicSpiral();
    }

    @Test
    void butterflyCurve() throws MWException {
        MatlabWork.butterflyCurve();
    }
}