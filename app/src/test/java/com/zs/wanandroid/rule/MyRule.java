package com.zs.wanandroid.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String methodName = description.getMethodName();
                System.out.println(methodName + " 开始测试！");
                base.evaluate();
                System.out.println(methodName + " 结束测试！");
            }
        };
    }
}
