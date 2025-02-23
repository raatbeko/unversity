package winodow;

import service.MainService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsoleWindow extends JFrame {
    private MainService mainService;

    public ConsoleWindow() {
        super("Консольное приложение");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Панель для меню с вертикальным расположением кнопок
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));  // Вертикальное расположение кнопок
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addFacultyButton = new JButton("Добавить факультет");
        JButton addStudentButton = new JButton("Добавить студента");
        JButton showStudentsButton = new JButton("Показать студентов");
        JButton exitButton = new JButton("Выйти");

        addFacultyButton.setPreferredSize(new Dimension(200, 50));
        addFacultyButton.setMaximumSize(new Dimension(300, 50));  // Ожидаемый размер кнопки
        addFacultyButton.setMinimumSize(new Dimension(200, 50));  // Минимальный размер кнопки

        addStudentButton.setPreferredSize(new Dimension(200, 50));
        addStudentButton.setMaximumSize(new Dimension(300, 50));  // Ожидаемый размер кнопки
        addStudentButton.setMinimumSize(new Dimension(200, 50));  // Минимальный размер кнопки

        showStudentsButton.setPreferredSize(new Dimension(200, 50));
        showStudentsButton.setMaximumSize(new Dimension(300, 50));  // Ожидаемый размер кнопки
        showStudentsButton.setMinimumSize(new Dimension(200, 50));  // Минимальный размер кнопки

        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.setMaximumSize(new Dimension(300, 50));  // Ожидаемый размер кнопки
        exitButton.setMinimumSize(new Dimension(200, 50));  // Минимальный размер кнопки


        addFacultyButton.addActionListener((ActionEvent e) -> executeCommand(1));
        addStudentButton.addActionListener((ActionEvent e) -> executeCommand(2));
        showStudentsButton.addActionListener((ActionEvent e) -> executeCommand(3));
        exitButton.addActionListener((ActionEvent e) -> executeCommand(5));

        menuPanel.add(addFacultyButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(addStudentButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(showStudentsButton);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(exitButton);
        menuPanel.add(Box.createHorizontalStrut(165));

        // Заголовок окна
        JLabel titleLabel = new JLabel("<html>============================<br>Меню:<br>============================<br>Выберите команду:<br>============================</html>", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Основной контейнер
        getContentPane().setLayout(new BorderLayout());

        // Добавляем заголовок по центру
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);

        // Кнопки добавляем по центру
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));  // Вертикальное расположение кнопок
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(menuPanel);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);  // Кнопки теперь по центру
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    public void display(String text) {
        JOptionPane.showMessageDialog(null, text, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    private void executeCommand(int choice) {
        switch (choice) {
            case 1 -> mainService.addFaculty();
            case 2 -> mainService.addStudentToFaculty();
            case 3 -> mainService.printFacultyStudents();
            case 5 -> {
                display("🚀 Завершение работы...");
                System.exit(0);  // Закрыть приложение
            }
            default -> display("❌ Некорректный ввод.");
        }
    }
}
