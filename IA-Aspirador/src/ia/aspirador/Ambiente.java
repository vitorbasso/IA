/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.aspirador;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Ambiente {
    
        private Quadrado quadradoEsquerdo;
        private Quadrado quadradoDireito;
        private Aspirador aspirator;
        private boolean fim;
        private int acao;
        private Scanner input;
        private static Ambiente ambiente;
    
        private Ambiente(){
            quadradoEsquerdo = new Quadrado(1, Posicao.ESQUERDA);
            quadradoDireito = new Quadrado(1, Posicao.DIREITO);
            quadradoEsquerdo.setVizinho(quadradoDireito);
            quadradoDireito.setVizinho(quadradoEsquerdo);
        
            aspirator = new Aspirador(quadradoDireito);
            
            this.acao = 0;
            
            this.fim = false;
            
            input = new Scanner(System.in);
            
            aspirator.ligarCerebro();
        }
        
        public static Ambiente getAmbiente(){
            if(ambiente == null){
                ambiente = new Ambiente();
            }
            return ambiente;
        }
        
        public void setAcao(int acao){
            this.acao = acao;
        }
        
        public int getAcao(){
            return acao;
        }
        
        
        public boolean getFim(){
            return fim;
        }
        
        public void setFim(boolean fim){
            this.fim = fim;
        }
        
        
        public void apresentarAmbiente(){
            while(!getFim()){
                System.out.println("\n O que gostaria de fazer?");
                System.out.println("1 - sujar quadrado Esquerdo.");
                System.out.println("2 - sujar quadrado Direito.");
                System.out.println("3 - sujar os dois quadrados.");
                System.out.println("(qualquer outro numero) - terminar o programa.\n");
                setAcao(input.nextInt());
                switch(getAcao()){
                    case 1:
                        System.out.println("Sujando o quadrado esquerdo:");
                        quadradoEsquerdo.sujar();
                        aspirator.ligarCerebro();
                        break;
                    case 2:
                        System.out.println("Sujando o quadrado direito:");
                        quadradoDireito.sujar();
                        aspirator.ligarCerebro();
                        break;
                    case 3:
                        System.out.println("Sujando os dois quadrados:");
                        quadradoDireito.sujar();
                        quadradoEsquerdo.sujar();
                        aspirator.ligarCerebro();
                        break;
                    default:
                        setFim(true);
                        System.out.println("Terminando o programa.\n");
                }
            }
        }
        
    
}
