import com.activecoding.studious.admin.Admin;
import com.activecoding.studious.student.Student;
import com.activecoding.studious.user.User;

import java.util.ArrayList;

public class CLI {
    public static void main(String[] args) {
        Student student = new Student();

        student.setFirstName("Odane");
        student.setLastName("Collins");
        student.setEmail("odanecollins@gmail.com");
        student.setSchool("UTECH");
        student.setCourse("BSc in Computer Science");

        System.out.println(student);


        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Brown");
        admin.setAdminID("JBROWN");
        admin.setEmail("jbrown96@gmail.com");

        ArrayList<Admin.Permission> permissions = new ArrayList<>();
        permissions.add(Admin.Permission.CREATE_MODULE);
        permissions.add(Admin.Permission.DELETE_MODULE);
        permissions.add(Admin.Permission.EDIT_MODULE);

        admin.setPermissions(permissions);

        System.out.println(admin);
    }
}
