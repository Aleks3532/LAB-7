пакет  com.company ;

импорт  javax.swing. * ;
импорт  java.awt. * ;
import  java.awt.event.ActionEvent ;
импорт  java.io.BufferedReader ;
import  java.io.FileInputStream ;
импорт  java.io.IOException ;
import  java.io.InputStreamReader ;
импорт  java.util.Deque ;
import  java.util.LinkedList ;

общественный  класс  MainForm  расширяет  JFrame {
    приватная  упаковка в JPanel ;
    частный  JPanel headerPanel;
    приватный  JPanel leftPanel;
    частный  JPanel rihgtPanel;
    частное  шоу JButton showButton;
    частный  JButton выбратьButton;
    частный  JLabel headerInfoLabel;
    частный  JLabel leftLabel;
    частный  JLabel rightLabel;
    закрытый  Deque < String > deque;

    MainForm () {
        ShowAction showAction =  new  ShowAction ();
        ChooseAction chooseAction =  new  ChooseAction ();
        String headerInformationString =  " <html> Мамонов В.Ю. <br> "  +
                " Задать форму: строки из файла, записать их в стек. Создать форму, строки в форме таблицы из двух колонок. " "  +
                " Одна колонка содержит строки в том порядке в котором они были в файле , а другой в обратном порядке <br> "  +
                " Реализовать на Фреймворке AWT, SWING и JavaFX </ html> " ;
        setVisible ( true );
        setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
        setContentPane (пленка);
        Инструментарий Инструментарий =  Инструментарий . getDefaultToolkit ();
        Размерность измерения = инструментарий . getScreenSize ();
        setBounds (размерность . ширина /  2  -  350 , размерность . высота /  2  -  350 , 700 , 700 );
        headerInfoLabel . SetText (headerInformationString);
        showButton . addActionListener (showAction);
        выберите кнопку . addActionListener (chooseAction);
    }

    частная  статическая  пустота  обычно ( Deque < String >  deque , JLabel  leftLabel ) {
        Deque < String > copy =  new  LinkedList <> (deque);
        StringBuilder text =  new  StringBuilder ( " <html> " );
        while ( ! copy . isEmpty ()) {
            текст . добавить (copy . pollFirst ()) . добавить ( " <br> " );
        }
        текст . append ( " </ html> " );
        leftLabel . setText ( String . valueOf (text));
    }

    частный  статический  недействительным  обратный ( Deque < строка >  Deque , JLabel  rightLabel ) {
        Deque < String > copy =  new  LinkedList <> (deque);
        StringBuilder text =  new  StringBuilder ( " <html> " );
        while ( ! copy . isEmpty ()) {
            текст . добавить (copy . pollLast ()) . добавить ( " <br> " );
        }
        текст . append ( " </ html> " );
        RightLabel . setText ( String . valueOf (text));
    }

    класс  ShowAction  расширяет  AbstractAction {
        @Override
        public  void  actionPerformed ( ActionEvent  e ) {
            обычный (deque, leftLabel);
            обратный (deque, rightLabel);
        }
    }
    класс  ChooseAction  расширяет  AbstractAction {
        @Override
        public  void  actionPerformed ( ActionEvent  e ) {
            JFileChooser fileopen =  new  JFileChooser ();
            int ret = fileopen . showDialog ( null , " Открыть файл " );
            if (ret ==  JFileChooser . APPROVE_OPTION ) {
                попытаться {
                    deque =  new  LinkedList <> ();
                    FileInputStream fstream =  new  FileInputStream (fileopen . GetSelectedFile () . ToString ());
                    BufferedReader br =  новый  BufferedReader ( новый  InputStreamReader (fstream));
                    Строка strLine;
                    while ((strLine = br . readLine ()) ! =  null ) {
                        дек . добавить (strLine);
                    }
                } catch ( IOException e1) {
                    е1 . printStackTrace ();
                }
            }
        }
    }
}