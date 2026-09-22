package encapsulationweek7.class_problems;

class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int capacity) {
        presentStudents = new String[Math.max(0, capacity)];
    }

    public void markPresent(String name) {
        if (name != null && !isPresent(name) && presentCount < presentStudents.length) {
            presentStudents[presentCount++] = name;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(name)) return true;
        }
        return false;
    }
}

public class Week7_Encapsulation_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ben");
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
