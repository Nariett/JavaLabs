package FormOne;

import java.awt.*;
import java.util.ArrayList; import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Задание один");
        frame.setPreferredSize(new Dimension(700,500));
        JPanel UpPanel = new JPanel(new GridLayout(2, 3));
        for(int i = 1; i < 7; i++){
            UpPanel.add(new TextField("Поле"+i));
        }
        frame.add(UpPanel, BorderLayout.NORTH);

        JPanel WestPanel = new JPanel(new GridLayout(9, 1));
        for(int i = 1; i < 10; i++){
            WestPanel.add(new Checkbox("Выбор"+i));
        }
        frame.add(WestPanel, BorderLayout.WEST);

        JPanel EastPanel = new JPanel(new GridLayout(1, 1));
        JTextArea text = new JTextArea();
        text.setColumns(20);
        text.setRows(5);
        EastPanel.add(text);
        frame.add(EastPanel, BorderLayout.EAST);
        JPanel CenterPanel = new JPanel(new FlowLayout());
        JPanel myPanel2=new JPanel(new FlowLayout());
        ButtonGroup myGroup=new ButtonGroup();
        ArrayList<JRadioButton> masRB=new ArrayList<JRadioButton>();
        myPanel2.setLayout(new GridLayout(3,2));
        for (int i=0;i<2;i++){
            masRB.add(new JRadioButton("Выбор "+i));
            myGroup.add(masRB.get(i));
            myPanel2.add(masRB.get(i));
        }
        masRB.get(0).setSelected(true);
        frame.add(myPanel2,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        }
}
