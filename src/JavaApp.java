public class JavaApp {
    public static void main(String[] args) {
        Obstacle[] obstacles = new Obstacle[4];
        RunAndJump[] persones = new RunAndJump[3];

        obstacles[0] = new Wall(1);
        obstacles[1] = new Treadmill(150);
        obstacles[2] = new Wall(3);
        obstacles[3] = new Treadmill(5);

        persones[0] = new Cat(5, 150);
        persones[1] = new Robot(2, 500);
        persones[2] = new Human(1, 300);

        for(RunAndJump j : persones){
            int z = 0;
            for (Obstacle o: obstacles){
                if (o.overcome(j))z++;
                else break;
            }
            System.out.printf("object of %s overcome %d obstacles\n", j.getClass(), z);
        }
    }
}
