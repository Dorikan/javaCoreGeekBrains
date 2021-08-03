public class Cat extends Animal{

    private static double maxRun;
    private static double maxJump;
    private final String name;

    public Cat(String name) {
        super(name);
        this.name=name;
        generateMax();
    }

    @Override
    public void run(double range) {
        if(range<maxRun) System.out.printf("%s пробежала %s метров\n", name, range);
        else System.out.printf("%s не может пробежать так далеко. его предел %f метров\n", name, maxRun);
    }

    @Override
    public void swim(double range) {
        System.out.println("Кошки не умеют плавать.");
    }

    @Override
    public void jump(double range) {
        if(range<maxJump) System.out.printf("%s прыгнула на %s метров\n", name, range);
        else System.out.printf("%s не может прыгнуть так высоко. его предел %f метров\n", name, maxJump);
    }

    private static void generateMax(){
        maxRun = (Math.random()*150+100);
        maxJump = (Math.random()*2+1);
    }
}
