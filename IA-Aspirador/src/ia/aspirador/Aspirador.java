/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.aspirador;

/**
 *
 * @author vitor
 */
public class Aspirador {
    
    private Quadrado posicao;
    private boolean ligado;
    
    public Aspirador(Quadrado posicao){
        setPosicao(posicao);
        ligado = false;
    }
    
    private void setPosicao(Quadrado posicao){
        this.posicao = posicao;
        System.out.println("Aspirador esta no quadrado " + this.posicao.getName() + "\n");
    }
    
    public void  andarEsquerda(){
        System.out.println("Aspirador andando para a Esquerda.");
        if(posicao.getName() == Posicao.DIREITO){
            setPosicao(posicao.getVizinho());
        }
    }
    
    public void andarDireita(){
        System.out.println("Aspirador andando para a Direita.");
        if(posicao.getName() == Posicao.ESQUERDA){
            setPosicao(posicao.getVizinho());
        }
    }
    
    public void limpar(){
        if(posicao.getSujo()){
            posicao.limpar();
            System.out.println("Aspirador limpando o quadrado " + posicao.getName());
        }
    }
    
    public void esperar(){
        ligado = false;
        System.out.println("Aspirador aguardando sujeira.");
    }
    
    public void ligarCerebro(){
        ligado = true;
        while(ligado){
            if(posicao.getSujo()){
            limpar();
            }else{
                if(posicao.getName() == Posicao.ESQUERDA){
                    andarDireita();
                }else{
                    andarEsquerda();
                }
                if(!posicao.getSujo()){
                    esperar();
                }
            }
        }
    }
    
}
