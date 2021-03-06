package lesson04_class_and_object_in_java.practice.class_rectangle;

public class Rectangle {
    double width, height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }
    public double getPrimeter() {
        return (this.width + this.height) * 2;
    }
    public String display() {
        return "Rectangle{" + "width" + width + ", height = " + height + " }";
    }
}
