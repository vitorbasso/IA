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
public class Quadrado {
    
    private Posicao name;
    private int sujo;
    private Quadrado vizinho;
    private Aspirador aspirador;
    
    public Quadrado(int sujo, Posicao name){
        this.sujo = sujo;
        this.name = name;
        this.vizinho = null;
        System.out.println("Quadrado " + name + " esta " + getEstado() + "\n");
    }
    
    public void setObserver(Aspirador aspirator){
        this.aspirador = aspirator;
    }
    
    public void setVizinho(Quadrado vizinho){
        this.vizinho = vizinho;
    }
    
    public Quadrado getVizinho(){
        return this.vizinho;
    }
    
    public Posicao getName(){
        return this.name;
    }
    
    public boolean getSujo(){
        return this.sujo == 1;
    }
    
    public void sujar(){
        this.sujo = 1;
        this.aspirador.ligarCerebro();
    }
    
    public void limpar(){
        this.sujo = 0;
    }
    
    public String getEstado(){
        return (getSujo() ? "SUJO" : "LIMPO");
                
    }
}
