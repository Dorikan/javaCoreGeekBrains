public class Dog extends Animal{

    private static double maxRun;
    private static double maxJump;
    private static double maxSwim;
    private final String name;

    public Dog(String name) {
        super(name);
        this.name=name;
        generateMax();
    }

    @Override
    public void run(double range) {
        if(range<maxRun) System.out.printf("%s пробежала %s метров\n", name, range);
        else System.out.printf("%s не может пробежать так далеко. еe предел %f метров\n", name, maxRun);
    }

    @Override
    public void swim(double range) {
        if (range<maxSwim) System.out.printf("%s проплыла %s метров.\n", name, range);
        else System.out.printf("%s не может столько проплыть. ее предел %f\n", name, maxSwim);
    }

    @Override
    public void jump(double range) {
        if(range<maxJump) System.out.printf("%s прыгнула на %s метров\n", name, range);
        else System.out.printf("%s не может прыгнуть так высоко. еe предел %f метров\n", name, maxJump);
    }

    private static void generateMax(){
        maxRun = (Math.random()*150+150);
        maxJump = (Math.random()*0.3+0.3);
        maxSwim = (Math.random()*10+5);
    }
}
