package Core_Java;

@FunctionalInterface
interface Operations {
    int add(int a,int b);
}
public class understanding_functional_interfaces {
    static void main() {
        Operations op1 = (a,b) -> a+b;
        System.out.println(op1.add(6,5));
    }
}
