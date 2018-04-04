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
public class IAAspirador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ambiente ambiente = Ambiente.getAmbiente();
        ambiente.apresentarAmbiente();
        
    }
    
}
