public class Cat implements RunAndJump{

    private final int jumpMax;
    private final int runMax;

    public Cat(int jumpMax, int runMax){
        this.jumpMax=jumpMax;
        this.runMax=runMax;
    }

    public boolean jump(int n){
        return jumpMax >= n;
    }
    public boolean run(int n){
        return runMax >= n;
    }

}
