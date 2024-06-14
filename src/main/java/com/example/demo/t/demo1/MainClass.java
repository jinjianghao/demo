package com.example.demo.t.demo1;

public class MainClass {
    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     * 程序分析：1.票数要使用同一个静态值
     *  2.为保证不会出现卖出同一个票数，要java多线程同步锁。
     * 设计思路：1.创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
     * 2.创建主方法调用类
     * */
    public static void main(String[] args) {
        //实例化站台对象，并为每一个站台取名字
         Station station1=new Station("窗口1");
         Station station2=new Station("窗口2");
         Station station3=new Station("窗口3");
     
        // 让每一个站台对象各自开始工作
         station1.start();
         station2.start();
         station3.start();
     
    }
 
}