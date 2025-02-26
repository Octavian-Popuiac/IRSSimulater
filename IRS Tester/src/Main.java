import javax.swing.*;

public class Main {
    public static void main(String[] args){
        try{
            SwingUtilities.invokeLater(() -> new Programa().criarJanela());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}