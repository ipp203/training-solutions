package packages.main;



public class MainProgram {
    public static void main(String[] args) {
        packages.greetings.Greeter greeter = new packages.greetings.Greeter();
        greeter.sayHello();
    }
}
