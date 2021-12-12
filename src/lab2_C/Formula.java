package lab2_C;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class Formula extends JFrame{
    private JButton button1 = new JButton("Вычислить"); // создаем кнопки
    private JButton button2 = new JButton("Очистить");
    private JButton button3 = new JButton("M+");
    private JButton button4 = new JButton("MC");
    private JButton button5 = new JButton("Сменить переменную");
    private JTextField input_x = new JTextField("0"); // создаем текстовое поле для ввода
    private JTextField input_y = new JTextField("0");
    private JTextField input_z = new JTextField("0");
    private JTextField result = new JTextField("0");
    private JTextField memory = new JTextField("0");
    private JLabel label1 = new JLabel("  Введите х:"); // создаем подписи к текстовым полям
    private JLabel label2 = new JLabel("  Введите y:");
    private JLabel label3 = new JLabel("  Введите z:");
    private JLabel label4 = new JLabel("  Результат:");
    private JLabel label5 = new JLabel("  Память:");
    private JRadioButton radio1 = new JRadioButton("Формула 1"); // создаем радиокнопки
    private JRadioButton radio2 = new JRadioButton("Формула 2");
    Double resultat = 0.0;
    Double sum = 0.0;


    // классы для расчетных формул
    public Double formula1(Double x, Double y, Double z) {
        return (Math.sin(3.14*y*y) + Math.log1p(y+y)) / (Math.sin(3.14*z*z) + Math.sin(x) + Math.log1p(z*z) + x*x + Math.pow(2.7, Math.cos(z*x)));
    }

    public Double formula2(Double x, Double y, Double z) {
        return Math.pow(Math.cos(Math.pow(2.7,y))+Math.pow(2.7,y*y)+Math.pow(1/x,1/2),1/4)/Math.pow(Math.cos(3.14*z*z*z)+Math.log1p(Math.pow(1+z,2)),Math.sin(x));
    }

    public Formula() {
        super (""); // заголовок окна
        this.setBounds(200, 200, 350, 300); // размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // обработка закрытия окна
        Container container = this; // контейнер под содержимое
        container.setLayout(new GridLayout(8, 3, 3, 2)); // в виде таблицы
        // добавляем содержимое
        ButtonGroup group = new ButtonGroup(); // группируем радиокнопки
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);

        container.add(label1);
        //label1.setHorizontalAlignment(SwingConstants.RIGHT); выравнивание по правому краю
        container.add(input_x);
        input_x.setBackground(Color.YELLOW);

        container.add(label2);
        container.add(input_y);
        input_y.setBackground(Color.GRAY);

        container.add(label3);
        container.add(input_z);
        input_z.setBackground(Color.GREEN);

        container.add(label4);
        container.add(result);
        result.setBackground(Color.MAGENTA);

        container.add(label5);
        container.add(memory);
        memory.setBackground(Color.LIGHT_GRAY);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);
        group1.add(button4);
        //group1.add(button5);

        button1.addActionListener(new ButtonEvent1()); // обработка нажатия кнопки
        container.add(button1);
        button1.setBackground(Color.PINK); // задаем цвет кнопок

        button2.addActionListener(new ButtonEvent2());
        container.add(button2);
        button2.setBackground(Color.CYAN);

        button3.addActionListener(new ButtonEvent3());
        container.add(button3);
        button3.setBackground(Color.BLUE);

        button4.addActionListener(new ButtonEvent4());
        container.add(button4);
        button4.setBackground(Color.YELLOW);
      //  button5.addActionListener(new ButtonEvent5());
    }
    // обрабатываем нажатие каждой кнопки
    class ButtonEvent1 implements ActionListener { // кнопка Вычислить
        public void actionPerformed (ActionEvent i) {
            Double x = Double.parseDouble(input_x.getText()); // из текста в число
            Double y = Double.parseDouble(input_y.getText());
            Double z = Double.parseDouble(input_z.getText());
            if(radio1.isSelected()) // если флаг на кнопке 1
                resultat = formula1(x, y, z);
            else
                resultat = formula2(x, y, z);
            result.setText(resultat.toString()); // результат в текст и вывести в текстовом поле
        }
    }
    class ButtonEvent2 implements ActionListener { // кнопка Очистить
        public void actionPerformed (ActionEvent i) {
            input_x.setText("0");
            input_y.setText("0");
            input_z.setText("0");
            result.setText("0");
        }
    }
    class ButtonEvent3 implements ActionListener { // кнопка М+
        public void actionPerformed (ActionEvent i) {
            sum = sum + resultat;
            memory.setText(sum.toString());
        }
    }
    class ButtonEvent4 implements ActionListener { // кнопка МС
        public void actionPerformed (ActionEvent i) {
            sum = 0.0;
            memory.setText("0");
        }
    }
    //class ButtonEvent5 implements ActionListener {

   // }
}
