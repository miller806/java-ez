import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReturn {

    public static void main(String[] args) throws InterruptedException {
        int messageCount = 5; // 消息数量

        // 模拟消息列表
        Message[] messages = new Message[messageCount];
        for (int i = 0; i < messageCount; i++) {
            messages[i] = new Message(i);
        }

        // 创建 CountDownLatch，计数器设置为消息数量
        CountDownLatch countDownLatch = new CountDownLatch(messageCount);

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 模拟消息处理
        for (Message message : messages) {
            executorService.execute(() -> {
                try {
                    // 模拟处理消息
                    Thread.sleep(1000);
                    System.out.println("处理消息：" + message);

                    // 模拟处理失败的情况，提前结束任务
                    if (message.getId() % 2 == 0) {
                        System.out.println("处理消息失败：" + message);
                        // 提前结束任务
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 每个消息处理完成后，调用 countDownLatch.countDown() 方法减少计数器
                    countDownLatch.countDown();
                }
            });
        }

        // 等待所有消息处理完成
        countDownLatch.await();

        // 所有消息处理完成后执行的操作
        System.out.println("所有消息处理完成，执行 ack.acknowledge()");
        // 模拟执行 ack.acknowledge() 操作
        System.out.println("acknowledged");

        // 关闭线程池
        executorService.shutdown();
    }

    // 模拟消息类
    static class Message {
        private int id;

        public Message(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "id=" + id +
                    '}';
        }
    }
}
