package lesson07_abstract_class_and_interface.practice.animal_and_interface_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: cluck cluck!";
    }

    @Override
    public String howtoEat() {
        return "eat chicken";
    }
}
