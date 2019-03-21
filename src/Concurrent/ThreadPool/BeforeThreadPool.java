package Concurrent.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ziv on 2019/3/21.
 * 几种与线程池相关的接口或类
 */

public class BeforeThreadPool{

}

/**
 * Executor 接口
 * 实现execute方法
 * 可以传入一个Runnable接口, runnable接口用于定义一项任务, 将任务传递给Executor后, 由 Executor.execute() 方法定义如何执行任务
 */
class MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}

/**
 * ExecutorService接口，继承自Executor
 * 是Executor的服务, service 一般都是一些后台线程, 跑在后台提供服务, 这里代表 执行器服务
 * ExecutorService就是这种线程, 启动后一直在后台等待任务扔到容器中执行.
 *
 * Future submit(Runnable): 提交Runnable任务以执行并返回表示该任务的Future。
 * Future submit(Runnable, result):
 * Future submit(Callable): 提交一个有返回值的callable任务,并将返回值作为future对象包装返回
 *
 * execute 和 submit 的区别:
 * 没有本质区别,只不过execute只能执行Runnable接口
 */
class MyExecutorService  {
    ExecutorService executorService = null;
}

/**
 * Callable接口
 * 类似Runnable, 执行Runnable任务时,实际调用的是run方法
 * 执行Callable任务时,实际调用的是 call方法
 *
 * 区别:
 *  1. callable 有返回值,线程运行结束后需要返回值,则需要callable
 *  2. callable可以抛出异常,而Runnable不能抛出异常,必须自己处理
 */
class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}

/**
 * 操作Executor的工具类
 */
class MyExecutors {
    Executors executors;
}

