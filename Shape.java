public class Shape {
    public double calculateArea(double length, double width) {
        return length * width;
    }
    public double calculatePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Shape shape = new Shape();
        double rectangleArea = shape.calculateArea(5, 3);
        double rectanglePerimeter = shape.calculatePerimeter(5, 3);

        System.out.println("Rectangle Area: " + rectangleArea);
        System.out.println("Rectangle Perimeter: " + rectanglePerimeter);
    }
}
