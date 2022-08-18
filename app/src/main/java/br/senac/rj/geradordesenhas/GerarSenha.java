package br.senac.rj.geradordesenhas;

import java.util.Locale;

public class GerarSenha {

    private String frase;
    private String uso;

    public GerarSenha(String frase, String uso) {
        this.frase = frase;
        this.uso = uso;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    private int verificaIndex(int pos, String text){
        while(pos >= text.length()){
            pos -= text.length();
        }
        return pos;
    }

    private String pegarSenha(String frase, String uso){
        String senha = "";
        String aux = "";
        String array[] = frase.split(" ");
        int pos = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);

        for(int i = 0; i < array.length - 1; i++){
            array[i] = array[i].replace(",", "");
            aux += array[i].charAt(verificaIndex(pos, array[i]));
        }

        senha = aux.substring(0, aux.length()/2) + uso + aux.substring(aux.length()/2);
        senha.toLowerCase(Locale.ROOT);
        return senha;
    }

    private String criptografa(String senha){
        senha = senha.replace("a", "@");
        senha = senha.replace("b", "8");
        senha = senha.replace("c", "C");
        senha = senha.replace("e", "3");
        senha = senha.replace("f", "G");
        senha = senha.replace("g", "9");
        senha = senha.replace("i", "1");
        senha = senha.replace("j", "J");
        senha = senha.replace("l", "L");
        senha = senha.replace("n", "N");
        senha = senha.replace("o", "0");
        senha = senha.replace("q", "Q");
        senha = senha.replace("s", "5");
        senha = senha.replace("t", "T");
        senha = senha.replace("v", "V");
        senha = senha.replace("x", "X");
        senha = senha.replace("z", "Z");

        return senha;
    }
}
