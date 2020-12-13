package week04.d01;

public class NameChanger {
    private String fullname;


    public NameChanger(String fullname) {
        if (fullname == null || fullname.isBlank()) {
            throw new IllegalArgumentException("Invalid name: " + fullname);
        }
        this.fullname = fullname.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void changeFirsName(String firstName) {
        String str = firstName.trim();
        fullname = fullname.replace(fullname.substring(fullname.indexOf(" ") + 1), str);
    }
}
