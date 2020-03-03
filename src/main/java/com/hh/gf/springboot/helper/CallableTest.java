package com.hh.gf.springboot.helper;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *
 * 线程的第三种创建方法
 *
 */
public class CallableTest {

    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest() ;
        //因为Callable接口是函数式接口，可以使用Lambda表达式
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0 ;
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName() + "111的循环变量i的值 ：" + i);
            }
            return i;
        });
        for(int i=0;i<100;i++){
            System.err.println(Thread.currentThread().getName()+" 222的循环变量i ：" + i);
            if(i==20){
                System.err.println("task :"+task);
                new Thread(task,"333有返回值的线程").start();
            }
        }
        try{
            System.out.println("444子线程返回值 ： " + task.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
