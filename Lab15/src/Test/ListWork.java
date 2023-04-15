package Test;

import TestTwo.Student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListWork extends JFrame {
    private HashMap<String, Student> students = new HashMap<>();
    public static void main(String[] args) {
        ListWork window = new ListWork("Работа с классами");
        window.setVisible(true);
        window.pack();
        window.setMinimumSize(window.getSize());
    }
    public ListWork(String s) {
        super(s);
        final DefaultListModel myListModel = new DefaultListModel();
        final JList myList = new JList();
        JScrollPane myScroll = new JScrollPane(myList);
        myList.setModel(myListModel);
        Box myBox1 = new Box(BoxLayout.Y_AXIS);
        final JLabel nameLabel = new JLabel("имя");
        JLabel nameLabelTwo = new JLabel("Возраст");
        JLabel nameLabelThree = new JLabel("Место жительства");

        JTextField myText = new JTextField(20); // 20 - это ширина текстового поля в символах
        JTextField age = new JTextField(20); // 20 - это ширина текстового поля в символах
        JTextField streetText = new JTextField(20); // 20 - это ширина текстового поля в символах
        myBox1.add(nameLabel); // добавляем метку "имя"
        myBox1.add(myText);
        myBox1.add(nameLabelTwo);
        myBox1.add(age);
        myBox1.add(nameLabelThree);
        myBox1.add(streetText);

        myList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = myList.getSelectedIndex();
                if (index != -1) {
                    String name = (String) myListModel.get(index);
                    Student student = students.get(name);

                    myText.setText(name);
                    age.setText(Integer.toString(student.getAge()));
                    streetText.setText(student.getAddress());
                }
            }
        });

        Box box1 = new Box(BoxLayout.X_AXIS);
        JButton button1 = new JButton("Добавить в список");
        box1.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = myText.getText();
                String ageStr = age.getText(); // Получаем текст из поля age
                int ageInt = Integer.parseInt(ageStr);
                String street = streetText.getText(); // Получаем текст из поля age
                Student student = new Student(ageInt, street);
                students.put(name, student);
                myListModel.addElement(name);
            }
        });
        JButton button2 = new JButton("Убрать из списка");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = myList.getSelectedIndex();
                if (index != -1) {
                    String name = (String) myListModel.get(index);
                    students.remove(name);
                    myListModel.remove(index);
                    myText.setText("");
                    age.setText("");
                    streetText.setText("");
                }
            }
        });
        box1.add(button2);
        JButton buttonClear = new JButton("Очистить список");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myListModel.clear();
            }
        });
        box1.add(buttonClear);
        myBox1.add(box1);
        add(myScroll, BorderLayout.CENTER);
        add(myBox1, BorderLayout.NORTH);
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
                            myListModel.addElement(name);
                        }
                    }myBReader.close();
                }
                catch (FileNotFoundException ex) {
                    // если файл не найден, то ничего страшного, мы просто не загрузим данные
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        myBox2.add(button4);
        add(myBox2, BorderLayout.SOUTH);
    }
}
