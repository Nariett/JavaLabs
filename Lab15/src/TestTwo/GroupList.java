package TestTwo;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GroupList extends JFrame {
    private HashMap<String, Student> students;

    public static void main(String[] args) {
        GroupList window = new GroupList("Список группы");
        window.setVisible(true);
        window.pack();
        window.setMinimumSize(window.getSize());
    }

    public GroupList(String s) {
        super(s);
        students = new HashMap<>();
        //loadFromFile(); // загружаем данные из файла

        final DefaultListModel<String> myListModel = new DefaultListModel<>();
        for (String name : students.keySet()) {
            myListModel.addElement(name);
        }
        final JList<String> myList = new JList<>(myListModel);
        JScrollPane myScroll = new JScrollPane(myList);
        Box myBox1 = new Box(BoxLayout.Y_AXIS);

        final JLabel ageLabel = new JLabel();
        final JLabel addressLabel = new JLabel();
        Box box2 = new Box(BoxLayout.X_AXIS);
        box2.add(new JLabel("Возраст: "));
        box2.add(ageLabel);
        box2.add(Box.createHorizontalGlue());
        box2.add(new JLabel("Адрес: "));
        box2.add(addressLabel);
        box2.add(Box.createHorizontalGlue());
        myBox1.add(box2);

        Box box1 = new Box(BoxLayout.X_AXIS);
        JButton button1 = new JButton("Добавить студента");
        box1.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(0, 2));
                panel.add(new JLabel("Имя студента:"));
                JTextField nameField = new JTextField();
                panel.add(nameField);
                panel.add(new JLabel("Возраст:"));
                JTextField ageField = new JTextField();
                panel.add(ageField);
                panel.add(new JLabel("Адрес:"));
                JTextField addressField = new JTextField();
                panel.add(addressField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Добавление студента", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    String address = addressField.getText();

                    Student student = new Student(age, address);
                    students.put(name, student);
                    myListModel.addElement(name);
                }
            }
        });

        JButton button2 = new JButton("Удалить студента");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = myList.getSelectedIndex();
                if (index != -1) {
                    String name = myListModel.get(index);
                    students.remove(name);
                    myListModel.remove(index);
                    ageLabel.setText("");
                    addressLabel.setText("");
                }
            }
        });
        box1.add(button2);

        JButton buttonClear = new JButton("Очистить список");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students.remove(students.keySet());
                myListModel.clear();
                ageLabel.setText("");
                addressLabel.setText("");
            }
        });
        box1.add(buttonClear);
        myBox1.add(box1);
        myList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = myList.getSelectedIndex();
                if (index != -1) {
                    String name = myListModel.get(index);
                    Student student = students.get(name);
                    ageLabel.setText(Integer.toString(student.getAge()));
                    addressLabel.setText(student.getAddress());
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(myBox1, BorderLayout.NORTH);
        panel.add(myScroll, BorderLayout.CENTER);
        getContentPane().add(panel);
        Box myBox2 = new Box(BoxLayout.X_AXIS);
        JButton button3 = new JButton("Сохранить...");
        myBox2.add(button3);
        final FileDialog fdlg = new FileDialog(this, "");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fdlg.setMode(FileDialog.SAVE);
                fdlg.setTitle("Сохранить файл");
                fdlg.setVisible(true);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(fdlg.getDirectory() + fdlg.getFile());
                    BufferedWriter myBWriter = new BufferedWriter(myWriter);
                    for (String name : students.keySet()) {
                        Student student = students.get(name);
                        String line = name + "," + student.getAge() + "," + student.getAddress();
                        myBWriter.write(line);
                        myBWriter.newLine();
                    }
                    myBWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        myBox2.add(Box.createHorizontalGlue());
        JButton button4 = new JButton("Загрузить...");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fdlg.setMode(FileDialog.LOAD);
                fdlg.setTitle("Загрузить файл");
                fdlg.setVisible(true);
                FileReader myReader = null;
                try {
                    myReader = new FileReader(fdlg.getDirectory() + fdlg.getFile());
                    myListModel.clear();
                    BufferedReader myBReader = new BufferedReader(myReader);
                    String s;
                    while ((s = myBReader.readLine()) != null) {
                        String[] parts = s.split(",");
                        if (parts.length == 3) {
                            String name = parts[0];
                            int age = Integer.parseInt(parts[1]);
                            String address = parts[2];
                            Student student = new Student(age, address);
                            students.put(name,student);
                        }
                    }myBReader.close();
                }
                catch (FileNotFoundException ex) {
                    // если файл не найден, то ничего страшного, мы просто не загрузим данные
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for (String name : students.keySet()) {
                    myListModel.addElement(name);
                }
            }
        });
        myBox2.add(button4);
        add(myBox2, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("nullnull"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    Student student = new Student(age, address);
                    students.put(name, student);
                }
            }
        } catch (FileNotFoundException e) {
            // если файл не найден, то ничего страшного, мы просто не загрузим данные
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}