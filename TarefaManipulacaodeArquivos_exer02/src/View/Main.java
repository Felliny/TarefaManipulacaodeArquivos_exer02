package View;

import Controller.SteamController;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path="D:\\TEMP";
        String name="SteamCharts.csv";
        String nome="nome.csv";
        String mes;
        int ano;
        int media;

        SteamController steamController= new SteamController();
        int opc= 0;
        while (opc != 9){
            opc= Integer.parseInt(JOptionPane.showInputDialog("MENU \n 1 - Pesquisar jogos por media de jogadores \n 2 - Criar um arquivo com a media de jogadores do mês de cada jogo \n 9 - Finalizar"));
            switch (opc){
                case 1: mes= JOptionPane.showInputDialog("Digite o mês");
                    ano= Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                    media= Integer.parseInt(JOptionPane.showInputDialog("Digite a media de jogadores"));
                    try {
                        steamController.readFile(path, name, mes, ano, media);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2: mes= JOptionPane.showInputDialog("Digite o mês");
                    ano= Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                    try {
                        steamController.CreateFile(path, name, nome, mes, ano);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9: break;
            }
        }


    }
}
