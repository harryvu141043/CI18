package tklibs;

public class Employee extends Human {
    @Override
    public void eat(){

        super.eat();//Human.eat()
        System.out.println(name+" eating done!");
    }
}
