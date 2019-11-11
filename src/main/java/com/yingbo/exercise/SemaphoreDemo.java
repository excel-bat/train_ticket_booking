/**
 * Copyright (C) 2008-2018 All Rights Reserved.
 */


package com.yingbo.exercise;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 使用信号量示例
 *
 * @author shanyingbo
 * @version $Id SemaphoreDemo.java, v 0.1 2018-06-11 上午10:50 shanyingbo Exp $$
 */
public class SemaphoreDemo {

  private static int data = 0;

  public static void main(String[] args) {
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    //Common Thread Pool
    ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    //创建一个Semaphore信号量，并设置最大并发数为3
    final Semaphore sp = new Semaphore(3);

    //availablePermits() //用来获取当前可用的访问次数
    System.out.println("初始化：当前有" + (3 - sp.availablePermits() + "个并发"));


    for (int index = 0; index < 10; index++) {
      //记录第几个任务
      final int NO = index;

      //具体任务
      pool.execute(()-> {
        try {
          // 获取许可
          sp.acquire();
          System.out.println(Thread.currentThread().getName()
                  + "获取许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
          //实现同步
          //synchronized(SemaphoreDemo.class) {
            System.out.println(Thread.currentThread().getName()
                    + "执行data自增前：data=" + data);
            data++;
            System.out.println(Thread.currentThread().getName()
                    + "执行data自增后：data=" + data);
         // }
          // 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
          sp.release();  //释放许可
          System.out.println(Thread.currentThread().getName()
                  + "释放许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
        } catch (InterruptedException e) {
        }
      });
    }

    pool.shutdown();

  }
}