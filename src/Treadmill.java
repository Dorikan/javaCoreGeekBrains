public class Treadmill extends Obstacle{
    int length;

    public Treadmill(int length){
        this.length = length;
    }

    @Override
    public boolean overcome(RunAndJump j) {
        return j.run(length);
    }
}
