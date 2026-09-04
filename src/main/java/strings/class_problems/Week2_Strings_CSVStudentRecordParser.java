package strings.class_problems;

public class Week2_Strings_CSVStudentRecordParser {
      static void parseStudentRecord(String csvLine) {

        String[] data = csvLine.split(",");

        if (data.length == 3) {

            System.out.println("Name: " + data[0]);
            System.out.println("Roll No: " + data[1]);
            System.out.println("Dept: " + data[2]);

        }
        else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {

        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}
