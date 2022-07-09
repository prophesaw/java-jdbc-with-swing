import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class componentss implements ActionListener {
    JFrame myframe = new JFrame("Form");
    JButton button = new JButton("submit");
    JButton find = new JButton("SEARCH");
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    JFormattedTextField datefield = new JFormattedTextField(format);
    JTextField[] textFields={new JTextField(),new JTextField(),new JTextField()};
    JLabel[] labels ={new JLabel("FIRST NAME:"),new JLabel("LAST NAME:"),new JLabel("D.O.B:"),new JLabel("PHONE N.O:"),new JLabel("GENDER"),new JLabel()};
    JCheckBox[] gender ={new JCheckBox("MALE"),new JCheckBox("FEMALE")};
    boolean state = false;
    boolean state1 = false;


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==gender[0]){
            if(state==false){
                state=true;
                gender[1].setEnabled(false);
            }else{
                state=false;
                gender[1].setEnabled(true);
            }
        }

        if(e.getSource()==gender[1]){
            if(state1==false){
                state1=true;
                gender[0].setEnabled(false);
            }else{
                state1=false;
                gender[0].setEnabled(true);
            }
        }
        if(e.getSource()==button){
            database();
        }
        if(e.getSource()==find){
            ResultSet rs = search(textFields[0].getText());
           try{
               if (rs.next()){
                   textFields[1].setText(rs.getString("last_name"));
                   datefield.setText(rs.getString("dob"));
                   textFields[2].setText(rs.getString("phone_no"));
                   labels[5].setText(rs.getString("gender"));

               }else{
                   JOptionPane.showMessageDialog(myframe,"DATA not valid");
               }
           }catch (Exception ex){
               ex.printStackTrace();
           }
        }

    }
    void database(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","");
            String insert = "INSERT INTO firstdb (first_name,last_name,dob,phone_no,gender)"+"VALUES(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1,textFields[0].getText());
            statement.setString(2,textFields[1].getText());
            statement.setString(3,datefield.getText());
            statement.setString(4,textFields[2].getText());
            if(gender[0].isSelected()){
                statement.setString(5,gender[0].getText());
            }else if(gender[1].isSelected()){
                statement.setString(5,gender[1].getText());
            }
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    ResultSet result = null;
    Connection cone = null;
    PreparedStatement statement = null;
    public ResultSet search (String s){
        try{
             cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdb","root","");
            String Query = "SELECT * FROM firstdb WHERE first_name=?";
            statement = cone.prepareStatement(Query);
            statement.setString(1,s);
            result = statement.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
