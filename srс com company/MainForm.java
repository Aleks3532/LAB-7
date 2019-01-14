�����  com.company ;

������  javax.swing. * ;
������  java.awt. * ;
import  java.awt.event.ActionEvent ;
������  java.io.BufferedReader ;
import  java.io.FileInputStream ;
������  java.io.IOException ;
import  java.io.InputStreamReader ;
������  java.util.Deque ;
import  java.util.LinkedList ;

������������  �����  MainForm  ���������  JFrame {
    ���������  �������� � JPanel ;
    �������  JPanel headerPanel;
    ���������  JPanel leftPanel;
    �������  JPanel rihgtPanel;
    �������  ��� JButton showButton;
    �������  JButton �������Button;
    �������  JLabel headerInfoLabel;
    �������  JLabel leftLabel;
    �������  JLabel rightLabel;
    ��������  Deque < String > deque;

    MainForm () {
        ShowAction showAction =  new  ShowAction ();
        ChooseAction chooseAction =  new  ChooseAction ();
        String headerInformationString =  " <html> ������� �.�. <br> "  +
                " ������ �����: ������ �� �����, �������� �� � ����. ������� �����, ������ � ����� ������� �� ���� �������. " "  +
                " ���� ������� �������� ������ � ��� ������� � ������� ��� ���� � ����� , � ������ � �������� ������� <br> "  +
                " ����������� �� ���������� AWT, SWING � JavaFX </ html> " ;
        setVisible ( true );
        setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
        setContentPane (������);
        �������������� �������������� =  �������������� . getDefaultToolkit ();
        ����������� ��������� = �������������� . getScreenSize ();
        setBounds (����������� . ������ /  2  -  350 , ����������� . ������ /  2  -  350 , 700 , 700 );
        headerInfoLabel . SetText (headerInformationString);
        showButton . addActionListener (showAction);
        �������� ������ . addActionListener (chooseAction);
    }

    �������  �����������  �������  ������ ( Deque < String >  deque , JLabel  leftLabel ) {
        Deque < String > copy =  new  LinkedList <> (deque);
        StringBuilder text =  new  StringBuilder ( " <html> " );
        while ( ! copy . isEmpty ()) {
            ����� . �������� (copy . pollFirst ()) . �������� ( " <br> " );
        }
        ����� . append ( " </ html> " );
        leftLabel . setText ( String . valueOf (text));
    }

    �������  �����������  ����������������  �������� ( Deque < ������ >  Deque , JLabel  rightLabel ) {
        Deque < String > copy =  new  LinkedList <> (deque);
        StringBuilder text =  new  StringBuilder ( " <html> " );
        while ( ! copy . isEmpty ()) {
            ����� . �������� (copy . pollLast ()) . �������� ( " <br> " );
        }
        ����� . append ( " </ html> " );
        RightLabel . setText ( String . valueOf (text));
    }

    �����  ShowAction  ���������  AbstractAction {
        @Override
        public  void  actionPerformed ( ActionEvent  e ) {
            ������� (deque, leftLabel);
            �������� (deque, rightLabel);
        }
    }
    �����  ChooseAction  ���������  AbstractAction {
        @Override
        public  void  actionPerformed ( ActionEvent  e ) {
            JFileChooser fileopen =  new  JFileChooser ();
            int ret = fileopen . showDialog ( null , " ������� ���� " );
            if (ret ==  JFileChooser . APPROVE_OPTION ) {
                ���������� {
                    deque =  new  LinkedList <> ();
                    FileInputStream fstream =  new  FileInputStream (fileopen . GetSelectedFile () . ToString ());
                    BufferedReader br =  �����  BufferedReader ( �����  InputStreamReader (fstream));
                    ������ strLine;
                    while ((strLine = br . readLine ()) ! =  null ) {
                        ��� . �������� (strLine);
                    }
                } catch ( IOException e1) {
                    �1 . printStackTrace ();
                }
            }
        }
    }
}