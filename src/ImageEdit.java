/**
 * Created by Мария on 27.12.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class Chemist extends JFrame{
    private static ArrayList<Med> meds = new ArrayList<Med>();

    Chemist() {
        JFrame f = new JFrame();
        f.setSize(1000, 550);
        f.setLocationRelativeTo(null);
        f.setTitle("Препарат");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(4, 1));
        // f.setBackground();

        JTextArea output = new JTextArea();
        JTextArea output1 = new JTextArea();
        output.setBackground(Color.green);
        output.setSize(8,100);

        //############ Новая запись
        JPanel newMed = new JPanel(new GridLayout(6,3));

        JLabel nameL = new JLabel("Название");
        JLabel countryL = new JLabel("Страна");
        JLabel groupL = new JLabel("Группа");
        JLabel dataL = new JLabel("Срок годности");
        JLabel amountL = new JLabel("Количество");
        JLabel priceL = new JLabel("Цена");

        final JTextField nameTF = new JTextField();
        final JTextField countryTF = new JTextField();
        final JTextField groupTF = new JTextField();
        final JTextField dataTF = new JTextField();
        final JTextField amountTF = new JTextField();
        final JTextField priceTF = new JTextField();

        newMed.add(nameL);
        newMed.add(nameTF);
        newMed.add(countryL);
        newMed.add(countryTF);
        newMed.add(groupL);
        newMed.add(groupTF);
        newMed.add(dataL);
        newMed.add(dataTF);
        newMed.add(amountL);
        newMed.add(amountTF);


        newMed.add(priceL);
        newMed.add(priceTF);

        f.add(newMed);

        JButton newMedBut = new JButton("Добавить");
        JButton updateBT = new JButton("Обновить");

        newMedBut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameTF.getText();
                String country = countryTF.getText();
                String group = groupTF.getText();
                String data = dataTF.getText();
                String amount= amountTF.getText();
                String price = priceTF.getText();

                if (name.length() == 0 || country.length() == 0 ||group.length() == 0 || data.length() == 0
                        ||amount.length() == 0
                        || price.length() == 0)
                    JOptionPane.showMessageDialog(null, "Невозможно произвести добавление");
                else {

                    meds.add(new Med( nameTF.getText(), countryTF.getText(), groupTF.getText(),
                            dataTF.getText(), amountTF.getText(), priceTF.getText()));




                    nameTF.setText("");
                    countryTF.setText("");
                    groupTF.setText("");
                    dataTF.setText("");
                    amountTF.setText("");
                    priceTF.setText("");



                    output.setText("");
                    for (Med m : meds)
                        output.setText(output.getText() +  "| Название: " + m.getName() + "| Страна: " + m.getCountry() +
                                "| Группа: " + m.getGroup() + "| Срок: " + m.getData() +
                                "| Количество: " + m.getAmount() + "| Цена: " + m.getPrice() + "\n");
                }

            }

        });

        f.add(new JScrollPane(output));

        // Поиск
        final JTextField searchTF = new JTextField();
        searchTF.setPreferredSize(new Dimension(100,20));
        JButton nnameS = new JButton("По названию");
        JButton editionS = new JButton("По производителю");
        JButton yearpublicS = new JButton("По группе");


        JButton delete = new JButton("Удалить");

        JButton change = new JButton("Изменить");

        final JTextField deleteTF = new JTextField();
        deleteTF.setPreferredSize(new Dimension(100,20));

        final JTextField changeTF = new JTextField();
        changeTF.setPreferredSize(new Dimension(100,20));

        JPanel addP = new JPanel(new FlowLayout());
        JButton save=new JButton("Сохранить");

        JButton rewrite=new JButton("Перезаписать");
        addP.add(newMedBut);
        addP.add(updateBT);
        addP.add(save);
        addP.add(rewrite);


        updateBT.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                           output.setText("");
                                           for (Med m : meds)
                                               output.setText(output.getText() +  "| Название: " + m.getName() + "| Страна: " + m.getCountry() +
                                                       "| Группа: " + m.getGroup() + "| Срок: " + m.getData() +
                                                       "| Количество: " + m.getAmount() + "| Цена: " + m.getPrice() + "\n");
                                       }
                                   }
        );

        rewrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Med m : meds) {
                    if (m.getName().toLowerCase().startsWith(changeTF.getText().toLowerCase()))

                        meds.get(meds.indexOf(m)).setName(nameTF.getText());
                    meds.get(meds.indexOf(m)).setCountry(countryTF.getText());
                    meds.get(meds.indexOf(m)).setGroup(groupTF.getText());
                    meds.get(meds.indexOf(m)).setData(dataTF.getText());
                    meds.get(meds.indexOf(m)).setAmount(amountTF.getText());
                    meds.get(meds.indexOf(m)).setPrice(priceTF.getText());



                }
                nameTF.setText("");
                countryTF.setText("");
                groupTF.setText("");
                dataTF.setText("");
                amountTF.setText("");
                priceTF.setText("");

            }
        });


        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    OutputStream f = new FileOutputStream("File.txt", true);
                    OutputStreamWriter writer = new OutputStreamWriter(f);
                    BufferedWriter out = new BufferedWriter(writer);
                    for(int i = 0; i < meds.size(); i++)
                    {
                        out.write(String.valueOf(meds.get(i)));
                        out.write("\t");
                        out.newLine();
                        out.flush();
                    }
                }
                catch(IOException ex)
                {
                    System.err.println(ex);
                }
            }
        });
        f.add(addP);
        JPanel searchP = new JPanel(new FlowLayout());

        searchP.add(searchTF);
        searchP.add(nnameS);
        searchP.add(editionS);
        searchP.add(yearpublicS);
        searchP.add(deleteTF);
        searchP.add(delete);
        searchP.add(changeTF);
        searchP.add(change);

        f.add(searchP);

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changeTF.getText().length() == 0)
                    JOptionPane.showMessageDialog(null, "Невозможно произвести изменения");
                else {
                    for (Med m : meds)
                        if (m.getName().toLowerCase().startsWith(changeTF.getText().toLowerCase())) {
                            nameTF.setText(m.getName());
                            countryTF.setText((m.getCountry()));
                            groupTF.setText((m.getGroup()));
                            dataTF.setText((m.getData()));
                            amountTF.setText((m.getAmount()));
                            priceTF.setText((m.getPrice()));
                            output.updateUI();
                        }

                }

            }
            //output.setText(output.getText());

        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteTF.getText().length() == 0)
                    JOptionPane.showMessageDialog(null, "Невозможно произвести удаление");
                else {
                    for (Med m : meds) {
                        if (m.getName().toLowerCase().startsWith(deleteTF.getText().toLowerCase()))
                            meds.remove(m);
                    }

                    //output.updateUI();

                }

            }
            //output.setText(output.getText());

        });
        // Слушатель для кнопки поиска названию
        nnameS.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Невозможно произвести поиск");
                } else {

                    output.setText("");
                    for (Med m : meds)
                        if (m.getName().toLowerCase().startsWith(searchTF.getText().toLowerCase()))
                            output.setText(output.getText() + "| Название: " + m.getName() + "| Страна: " + m.getCountry() +
                                    "| Группа: " + m.getGroup() + "| Срок: " + m.getData() +
                                    "| Количество: " + m.getAmount() + "| Цена: " + m.getPrice() + "\n");
                }
            }

        });
        //Слушатель для кнопки поиска по стране
        editionS.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Невозможно произвести поиск");
                } else {
                    output.setText("");
                    for (Med m : meds)
                        if (m.getCountry().toLowerCase().startsWith(searchTF.getText().toLowerCase()))
                            output.setText(output.getText() + "| Название: " + m.getName() + "| Страна: " + m.getCountry() +
                                    "| Группа: " + m.getGroup() + "| Срок: " + m.getData() +
                                    "| Количество: " + m.getAmount() + "| Цена: " + m.getPrice() + "\n");
                }
            }
        });



        // Слушатель для кнопки поиска по группе
        yearpublicS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Невозможно произвести поиск");
                } else {
                    output.setText("");

                    for (Med m : meds)
                        if ((m.getGroup().toLowerCase().startsWith(searchTF.getText().toLowerCase())))
                            output.setText(output.getText() + "| Название: " + m.getName() + "| Страна: " + m.getCountry() +
                                    "| Группа: " + m.getGroup() + "| Срок: " + m.getData() +
                                    "| Количество: " + m.getAmount() + "| Цена: " + m.getPrice() + "\n");
                }
            }

        });



        f.setVisible(true);
    }
}