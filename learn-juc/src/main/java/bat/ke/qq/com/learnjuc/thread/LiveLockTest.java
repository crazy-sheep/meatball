package bat.ke.qq.com.learnjuc.thread;

public class LiveLockTest {

    /**
     * 定义一个勺子，ower 表示这个勺子的拥有者
     */
    static class Spoon {
        Diner owner;

        public Spoon(Diner diner) {
            this.owner = diner;
        }

        public String getOwnerName() {
            return owner.getName();
        }

        public void setOwner(Diner diner) {
            this.owner = diner;
        }

        //表示正在用餐
        public void use() {
            System.out.println(owner.getName() + " 用这个勺子吃饭.");
        }
    }

    /**
     * 定义一个晚餐类
     */
    static class Diner {

        private boolean isHungry;
        //用餐者的名字
        private String name;

        public Diner(boolean isHungry, String name) {
            this.isHungry = isHungry;
            this.name = name;
        }

        //和某人吃饭
        public void eatWith(Diner diner, Spoon sharedSpoon) {
            try {
                synchronized (sharedSpoon) {
                    while (isHungry) {
                        //当前用餐者和勺子拥有者不是同一个人，则进行等待
                        while (!sharedSpoon.getOwnerName().equals(name)) {
                            sharedSpoon.wait();
                        }
                        if (diner.isHungry()) {
                            System.out.println(diner.getName()
                                    + " 饿了，" + name + "把勺子给他.");
                            sharedSpoon.setOwner(diner);
                            sharedSpoon.notifyAll();
                        } else {
                            //用餐
                            sharedSpoon.use();
                            sharedSpoon.setOwner(diner);
                            isHungry = false;
                        }
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(name + " is interrupted.");
            }
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void setHungry(boolean hungry) {
            isHungry = hungry;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        final Diner ant = new Diner(true, "ant");
        final Diner monkey = new Diner(true, "monkey");
        final Spoon sharedSpoon = new Spoon(monkey);

        Thread h = new Thread(()->ant.eatWith(monkey, sharedSpoon));
        h.start();


        Thread w = new Thread(()->monkey.eatWith(ant, sharedSpoon));
        w.start();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //   h.interrupt();
        //   w.interrupt();

    }
}
