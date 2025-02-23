package service;

import domain.Faculty;
import domain.Student;
import domain.University;
import winodow.ConsoleWindow;

import javax.swing.*;
import java.util.List;

public class MainService {

    private final University university = University.getInstance();
    private final FacultyService facultyService = FacultyService.createService();
    private final ConsoleWindow console;

    public MainService(ConsoleWindow console) {
        this.console = console;
    }

    public void addFaculty() {
        String name = JOptionPane.showInputDialog("Введите название факультета:");
        if (name != null && !name.trim().isEmpty()) {
            facultyService.create(name);
            console.display("✅ Факультет '" + name + "' успешно добавлен.");
        }
    }

    public void addStudentToFaculty() {
        List<Faculty> faculties = university.getFaculties();

        if (faculties.isEmpty()) {
            console.display("❌ В университете нет факультетов.");
            return;
        }

        JList<Faculty> facultyList = new JList<>(faculties.toArray(new Faculty[0]));
        facultyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        facultyList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(facultyList);

        int option = JOptionPane.showConfirmDialog(
                console,
                scrollPane,
                "Выберите факультет",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            Faculty selectedFaculty = facultyList.getSelectedValue();
            if (selectedFaculty != null) {
                String studentName = JOptionPane.showInputDialog("Введите имя студента:");
                if (studentName != null && !studentName.trim().isEmpty()) {
                    Student student = new Student(studentName);
                    facultyService.addStudent(selectedFaculty, student);
                    console.display("✅ Студент '" + studentName + "' добавлен на факультет '" + selectedFaculty.getName() + "'.");
                } else {
                    console.display("❌ Имя студента не может быть пустым.");
                }
            }
        }
    }

    public void printFacultyStudents() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================\n");
        sb.append("         СПИСОК СТУДЕНТОВ\n");
        sb.append("=====================================\n");

        if (university.getFaculties().isEmpty()) {
            sb.append("❌ В университете нет факультетов.\n");
        } else {
            for (Faculty faculty : university.getFaculties()) {
                sb.append("-------------------------------------\n");
                sb.append(String.format("Факультет: %-25s%n", faculty.getName()));
                sb.append("-------------------------------------\n");
                if (faculty.getStudents().isEmpty()) {
                    sb.append("   ❌ Нет студентов.\n");
                } else {
                    for (Student student : faculty.getStudents()) {
                        sb.append(String.format("   - %-30s%n", student.getFullName()));
                    }
                }
            }
        }
        sb.append("=====================================\n");
        console.display(sb.toString());
    }
}
