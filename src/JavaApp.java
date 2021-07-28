public class JavaApp {

    private static Person[] personArr = new Person[5];

    public static void main(String[] args) {
        createPersonArr();
        printPersArrInfo();
    }
    private static void createPersonArr(){
        Person tempPerson1 = new Person("Иван Иванов Иванович1", "Инжинер", "ivanIvanov1@gmail.com", "892312311", generateRandomSalary(), generateRandomAge());
        Person tempPerson2 = new Person("Иван Иванов Иванович2", "Физик", "ivanIvanov2@gmail.com", "892312312", generateRandomSalary(), generateRandomAge());
        Person tempPerson3 = new Person("Иван Иванов Иванович3", "Бухгалтер", "ivanIvanov3@gmail.com", "892312313", generateRandomSalary(), generateRandomAge());
        Person tempPerson4 = new Person("Иван Иванов Иванович4", "Системный администратор", "ivanIvanov4@gmail.com", "892312314", generateRandomSalary(), generateRandomAge());
        Person tempPerson5 = new Person("Иван Иванов Иванович5", "Директор", "ivanIvanov5@gmail.com", "892312315", generateRandomSalary(), generateRandomAge());

        for(int i=0; i<personArr.length;i++){
            switch (i) {
                case 0 -> personArr[i] = tempPerson1;
                case 1 -> personArr[i] = tempPerson2;
                case 2 -> personArr[i] = tempPerson3;
                case 3 -> personArr[i] = tempPerson4;
                case 4 -> personArr[i] = tempPerson5;
            }
        }
    }
    private static void printPersArrInfo(){
        for(Person i : personArr) {
            i.printInfo();
            System.out.println();
        }
    }
    private static int generateRandomAge(){
        return (int)(Math.random()*60+21);
    }
    private static int generateRandomSalary(){
        return (int)(Math.random()*70000+30000);
    }
}
