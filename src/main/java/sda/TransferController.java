package sda;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import services.BankWrapperSingleton;

public class TransferController {

    @FXML
    private TextField id;

    @FXML
    private TextField amount;

    @FXML
    private TextField PIN;

    @FXML
    private Button transfer_bt;

    @FXML
    private ImageView home_btn;

    @FXML
    private Text status;
    @FXML
    public void initialize() {
        home_btn.setOnMouseClicked(arg0 ->
        {
            try {
                App.setRoot("Customer/customer_main_page");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        transfer_bt.setOnAction(e ->handletranfer());
    }
    public void handletranfer() {
        String id1=id.getText();
        Double amount1=Double.parseDouble(amount.getText());
        if(amount1>100000.0)
        {
            status.setText("Too large an amount");
            return;
        }
        if(amount1<0)
        {
            status.setText("Invalid Input");
            return;
        }
        int PIN1=Integer.parseInt(PIN.getText());
        String s=BankWrapperSingleton.getInstance().getB().transfer(id1,amount1,PIN1);
        status.setText(s);

        
    }

    // Add your controller logic here
    
}
