package encapsulationweek7.assignment_problems;

class TrafficLight {
    private String color;

    TrafficLight(String color) {
        this.color = color.equals("green") || color.equals("yellow") ? color : "red";
    }

    public void next() {
        if (color.equals("red")) color = "green";
        else if (color.equals("green")) color = "yellow";
        else color = "red";
    }

    public String getColor() {
        return color;
    }
}

public class Week7_Encapsulation_TrafficLight {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("red");
        light.next();
        System.out.println(light.getColor());
    }
}
