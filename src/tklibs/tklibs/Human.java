package tklibs;

public class Human {
    //thuoctinh
    String name;
    int age;
    String gender;
    //hàm tạo
    public Human(){//hàm tạo rỗng
        name="New person";
        age=20;
        gender="male";
    }
    //hàm tạo đầy đủ
    public Human(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    //phương thức
    public void eat(){
        System.out.println(name+" Eating..");
    }
    public void sleep(){
        System.out.println(name+" sleeping..");
    }
}
