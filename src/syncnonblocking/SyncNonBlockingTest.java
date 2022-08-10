package syncnonblocking;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SyncNonBlockingTest {

    static class WorkerA {

        Consumer<String> ownJob = (message) -> {
            for (int index = 0; index < 3; index++) {
                for (int subIndex = 0; subIndex < 300000; subIndex++) {
                }
                System.out.println("A: doing something.");
            }
            System.out.println("A: " + message);
        };

        Consumer<String> workForB = (message) -> {
            for (int index = 0; index < 3; index++) {
                for (int subIndex = 0; subIndex < 300000; subIndex++) {
                }
                System.out.println("B: doing something.");
            }
            System.out.println("B: " + message);
        };

        void doMyWork() {
            ownJob.accept("I'm worker A. And I'm done.");
        }

        public Consumer<String> getWorkForB() {
            return workForB;
        }

        void isWorkForBFinished(CompletableFuture<Void> joinPoint) {
            while (!joinPoint.isDone()) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A: Worker B is still working. Continue check what B is finished.");
            }
            System.out.println("A: Worker B is done. I'm gonna doing my work.");
        }
    }

    static class WorkerB {
        CompletableFuture<Void> doMyWork(Consumer<String> myWork) {
            return CompletableFuture.runAsync(() -> myWork.accept("I'm worker B. And I'm done."));
        }
    }

    public static void main(String[] args) {
        WorkerA a = new WorkerA();
        WorkerB b = new WorkerB();
        Consumer<String> workForB = a.getWorkForB(); // workForB을 리턴 받아 실행
        CompletableFuture<Void> joinPoint = b.doMyWork(workForB); // 끝나면 I'm worker B. And I'm done. 출력하도록 함
        a.isWorkForBFinished(joinPoint); // b가 끝났는지 체크
        a.doMyWork(); // a의 일을 실행
    }
}