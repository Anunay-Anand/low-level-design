package LLD.DecoratorPattern;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);

        System.out.println("The cost of coffee with Milk is " + coffee.getCost());

        coffee = new SugarDecorator(coffee);

        System.out.println("The coffee has " + coffee.getDescription());
    }
}
