package otherTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HeartbeatExample {
    public static void main(String[] args) {
        // 创建一个调度任务的线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        // 定义一个心跳任务
        Runnable heartbeatTask = () -> {
            System.out.println("心跳: " + System.currentTimeMillis());
        };

        // 每隔1秒执行一次心跳任务
        executorService.scheduleAtFixedRate(heartbeatTask, 0, 1, TimeUnit.SECONDS);

        // 为了演示，主线程睡眠5秒，然后关闭调度器
        try {
            Thread.sleep(5000); // 运行5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown(); // 关闭调度器
            System.out.println("心跳停止");
        }
    }
}
