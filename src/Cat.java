public class Cat {
    private String name;
    private int appetite;
    private boolean hunger = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        hunger = p.decreaseFood(appetite);
    }
    public boolean getHunger(){return hunger;}

    public String getName() {return name;}
}