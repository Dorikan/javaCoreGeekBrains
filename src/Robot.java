public class Robot implements RunAndJump{

    private final int jumpMax;
    private final int runMax;

    public Robot(int jumpMax, int runMax){
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
