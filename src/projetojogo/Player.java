/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

import java.awt.Graphics;

/**
 *
 * @author Galhardo
 */
public class Player extends Base {
    
        @Override
        public void desenhar(Graphics g) {
        g.setColor(prenchimento);
        g.fillRect(x, y, largura, altura);
        g.setColor(borda);
        g.drawRect(x, y, largura, altura);
        }
}
