import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class functiones extends componentss {
    int x=20;
    int y=20;
    int ty = 20;
    int tx=120;
    functiones(){

      for(int i=0;i<4;i++){
          labels[i].setBounds(x,y,100,30);
          y+=40;
           myframe.add(labels[i]);
      }
      for(int m=0;m<3;m++){
          textFields[m].setBounds(tx,ty,200,30);
          ty+=40;
          if(m==2){
              textFields[m].setBounds(tx,140,200,30);
              //String getNum = textFields[m].getText();
              textFields[m].addKeyListener(new KeyListener() {
                  @Override
                  public void keyTyped(KeyEvent e) {

                  }

                  @Override
                  public void keyPressed(KeyEvent e) {
                    String getNum = textFields[2].getText();
                    int lenght = getNum.length();
                    char c = e.getKeyChar();
                    if(e.getKeyChar()>='0'&&e.getKeyChar()<='9'){
                        if(lenght<11){
                          textFields[2].setEditable(true);
                        }else {
                            textFields[2].setEditable(false);
                        }
                    }else{
                        if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE){
                            textFields[2].setEditable(true);
                        }else{
                            textFields[2].setEditable(false);
                        }
                    }



                  }

                  @Override
                  public void keyReleased(KeyEvent e) {


                  }
              });
          }
          myframe.add(textFields[m]);
      }
      datefield.setBounds(tx,100,200,30);
      datefield.setText("YYYY-MM-DD");
      labels[4].setBounds(x,180,100,30);
      labels[5].setBounds(70,180,50,30);

      gender[0].setBounds(20,220,100,30);
      gender[1].setBounds(210,220,100,30);
      gender[0].addActionListener(this);
      gender[1].addActionListener(this);
      button.setBounds(110,300,200,40);
      button.setFocusable(false);
      button.addActionListener(this);
      find.addActionListener(this);
      find.setBounds(110,350,200,40);
      find.setFocusable(false);





        myframe.add(datefield);
        myframe.add(find);
        myframe.add(button);
        myframe.add(labels[4]);
        myframe.add(labels[5]);
        myframe.add(gender[0]);
        myframe.add(gender[1]);
        myframe.setBackground(Color.cyan);
        myframe.setLayout(null);
        myframe.setResizable(true);
        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myframe.setSize(420,500);
        myframe.setVisible(true);
    }
    
}
