import  java.awt.event.*;
import  java.io.*;
import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.image.*;
import  javax.imageio.*;
import  javax.swing.filechooser.FileFilter;
 
public class ImageEdit
{
   
    int  rezhim=0;
    int  xPad;
    int  xf;
    int  yf;
    int  yPad;
    int  thickness;
    boolean pressed=false;
    
    Color maincolor;
    MyFrame f;
    MyPanel japan;
    JButton colorbutton;
    JColorChooser tcc;
    
    BufferedImage imag;
    
    boolean loading=false;
    String fileName;
    public ImageEdit()
    {
        f=new MyFrame("Графический редактор");
        f.setSize(350,350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maincolor=Color.black;
         
        JMenuBar menuBar = new  JMenuBar();
        f.setJMenuBar(menuBar);
        menuBar.setBounds(0,0,350,30);
        JMenu fileMenu = new  JMenu("Файл");
        menuBar.add(fileMenu);
         
        Action loadAction = new  AbstractAction("Загрузить")
        {
           public void actionPerformed(ActionEvent event)
           {
              JFileChooser jf= new  JFileChooser();
              int  result = jf.showOpenDialog(null);
               if(result==JFileChooser.APPROVE_OPTION)
                {
                  try
                  {
                      
                       fileName = jf.getSelectedFile().getAbsolutePath();
                       File iF= new  File(fileName);
                       jf.addChoosableFileFilter(new  TextFileFilter(".png"));
                       jf.addChoosableFileFilter(new  TextFileFilter(".jpg"));
                       imag = ImageIO.read(iF);
                       loading=true;
                       f.setSize(imag.getWidth()+40, imag.getWidth()+80);
                       japan.setSize(imag.getWidth(), imag.getWidth());
                        japan.repaint();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(f, "Такого файла не существует");
                    } 
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(f, "Исключение ввода-вывода");
                    }
                  catch (Exception ex) {
                    }
                }
              }
            };
        JMenuItem loadMenu = new  JMenuItem(loadAction);
        fileMenu.add(loadMenu);
         
        Action saveAction = new  AbstractAction("Сохранить")
        {
           public void actionPerformed(ActionEvent event)
           {
               try
               {
                   JFileChooser jf= new  JFileChooser();
                   // Создаем фильтры  файлов
                   TextFileFilter pngFilter = new TextFileFilter(".png");
                   TextFileFilter jpgFilter = new TextFileFilter(".jpg");
                   if(fileName==null)
                   {
                       // Добавляем фильтры
                        jf.addChoosableFileFilter(pngFilter);
                        jf.addChoosableFileFilter(jpgFilter);
                       int  result = jf.showSaveDialog(null);
                       if(result==JFileChooser.APPROVE_OPTION)
                       {
                           fileName = jf.getSelectedFile().getAbsolutePath();
                       }
                       }
               }
           