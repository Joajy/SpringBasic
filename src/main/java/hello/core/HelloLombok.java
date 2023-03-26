package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    //Getter 및 Setter를 lombok으로부터 가져와서 자동으로 생성 가능
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");

//        String name = helloLombok.getName();
//        System.out.println("name = " + name);
        //@ToString 어노테이션으로 한 번에 처리
        System.out.println("helloLombok = " + helloLombok);
    }
}
