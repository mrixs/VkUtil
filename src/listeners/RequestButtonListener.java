package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import Methods.Friends;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ui.Window;
import utils.MyMath;

/**
 * Created by Mrixs on 01.Aug.2015 16:44
 * Project: vk_util
 * Package: listeners
 */
public class RequestButtonListener implements ActionListener {
    JTextField textField, medianInput, mediumInput, friendsInput,friendsAgeInput;
    Window window;
    JTextArea textArea;

    public RequestButtonListener(JTextField idInput, JTextField medianInput, JTextField mediumInput, JTextField friendsInput, JTextField friendsAgeInput, JTextArea textArea, Window window) {
        this.textField = idInput;
        this.window = window;
        this.textArea = textArea;
        this.medianInput = medianInput;
        this.mediumInput = mediumInput;
        this.friendsInput = friendsInput;
        this.friendsAgeInput = friendsAgeInput;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        List agesList =new ArrayList();
        Integer id = null;
        try {
            id = Integer.parseInt(textField.getText());
        } catch (Exception e1){
            textArea.append("\n Enter valid Vk ID \n Only numeric characters allowed \n");
        }
        String resultJSON = Friends.get("user_id=" + id.toString() + "&fields=bdate");
        textArea.append(resultJSON);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject=null;
        ArrayList response= null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(resultJSON);
            response = (JSONArray) jsonObject.get("response");
            friendsInput.setText(String.valueOf(response.size()));
            Iterator iterator = response.iterator();
            while (iterator.hasNext()){
                int age;
                JSONObject current = (JSONObject) iterator.next();
                textArea.append(current.toString()+"\n");
                if (current.get("bdate")==null){
                    continue;
                }
                String bdate = current.get("bdate").toString();
                if (bdate.length()<8){
                    continue;
                }
                else {
                    SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
                    Date date = sdf.parse(bdate);
                    Date now = new Date();
                    age = (now.getYear()) - (date.getYear());
                    if ((now.getMonth() < date.getMonth()) | now.getMonth()==date.getMonth()&now.getDay()<=date.getDay() ) {
                        age--;
                    }
                }
                agesList.add(age);
            }
        } catch (Exception e1) {
            textArea.append("\n\n" + e1.toString() + "\n");
        }
        mediumInput.setText(String.valueOf(MyMath.medium(agesList)));
        medianInput.setText(String.valueOf(MyMath.median(agesList)));
        friendsAgeInput.setText(String.valueOf(agesList.size()));
    }
}
