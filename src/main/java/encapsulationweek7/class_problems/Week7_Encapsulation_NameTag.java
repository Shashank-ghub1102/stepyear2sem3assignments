package encapsulationweek7.class_problems;

class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] parts = (fullName == null ? "" : fullName.trim()).split("\\s+");
        firstName = parts.length == 0 ? "" : parts[0];
        lastName = parts.length < 2 ? "" : parts[parts.length - 1];
    }

    public String getNickname() {
        return lastName.isEmpty() ? firstName : firstName + " " + lastName.charAt(0) + ".";
    }
}

public class Week7_Encapsulation_NameTag {
    public static void main(String[] args) {
        System.out.println(new NameTag("Maria Gomez").getNickname());
    }
}
