public class Wall extends Obstacle{
    int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public boolean overcome(RunAndJump j) {
        return j.jump(height);
    }
}
