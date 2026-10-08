package abstractionweek9.class_problems;

import java.util.Scanner;

// Abstract base class representing a generic garden plot
abstract class GardenPlot {
    protected String owner;
    protected String shapeType;

    public GardenPlot(String owner, String shapeType) {
        this.owner = owner;
        this.shapeType = shapeType;
    }

    public String getOwner() {
        return owner;
    }

    public String getShapeType() {
        return shapeType;
    }

    // Abstract method: each plot shape calculates its area differently
    public abstract double calculateArea();
}

// Circular plot
class CirclePlot extends GardenPlot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangular plot
class RectanglePlot extends GardenPlot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Triangular plot
class TrianglePlot extends GardenPlot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Week9_Abstraction_GardenPlotAreaReport {
    public static void generateReport(GardenPlot[] plots) {
        double totalArea = 0.0;
        for (GardenPlot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShapeType(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            GardenPlot[] samplePlots = {
                new CirclePlot("Asha", 5),
                new RectanglePlot("Ravi", 4, 6),
                new TrianglePlot("Neha", 10, 3)
            };
            generateReport(samplePlots);
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        GardenPlot[] plots = new GardenPlot[n];
        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            if ("CIRCLE".equalsIgnoreCase(shape)) {
                double radius = scanner.nextDouble();
                plots[i] = new CirclePlot(owner, radius);
            } else if ("RECTANGLE".equalsIgnoreCase(shape)) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plots[i] = new RectanglePlot(owner, length, width);
            } else if ("TRIANGLE".equalsIgnoreCase(shape)) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        generateReport(plots);
        scanner.close();
    }
}
