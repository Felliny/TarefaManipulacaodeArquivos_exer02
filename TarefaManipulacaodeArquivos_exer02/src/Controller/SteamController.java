package Controller;

import java.io.*;

public class SteamController {



    public SteamController(){
        super();
    }


    public void readFile(String path, String name, String mes, int ano, int media) throws IOException {
        File arq= new File(path, name);
        if (arq.exists() && arq.isFile()){
            FileInputStream fluxo= new FileInputStream(arq);
            InputStreamReader leitor= new InputStreamReader(fluxo);
            BufferedReader buffer= new BufferedReader(leitor);
            String linha= buffer.readLine();
            String[] vetor;
            while (linha != null){
                if (linha.contains(mes) && linha.contains(Integer.toString(ano))){
                    vetor= linha.split(",");
                    if (Float.parseFloat(String.valueOf(vetor[3])) >= media){
                        System.out.println(vetor[0] +", Media de jogadores: "+ vetor[3]);
                    }
                }
                linha= buffer.readLine();
            }
            buffer.close();
            fluxo.close();
            leitor.close();
        }
        else {
            throw new IOException("Arquivo Inválido!");
        }
    }


    public void CreateFile(String path, String name, String nome, String mes, int ano) throws IOException{
        File dir= new File(path);
        if (dir.exists() && dir.isDirectory()){
            File arq= new File(path, name);
            File jogos= new File(path, nome);
            boolean existe= false;
            if (arq.exists()){
                existe= true;
            }
            FileInputStream fluxo= new FileInputStream(arq);
            InputStreamReader leitor= new InputStreamReader(fluxo);
            BufferedReader buffer= new BufferedReader(leitor);
            FileWriter abre= new FileWriter(jogos, existe);
            PrintWriter escreve= new PrintWriter(abre);
            String linha= buffer.readLine();
            String[] vetor;
            while (linha != null){
                if (linha.contains(mes) && linha.contains(Integer.toString(ano))){
                    vetor= linha.split(",");
                    escreve.write(vetor[0] +", Media de jogadores: "+ vetor[3] +"\n");
                    escreve.flush();
                }
                linha= buffer.readLine();
            }
            escreve.close();
            abre.close();
            buffer.close();
            leitor.close();
            fluxo.close();
        }
        else {
            throw new IOException("Diretorio Inválido!");
        }
    }

}
