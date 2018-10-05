/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Galhardo
 */
public class FrmJogo extends javax.swing.JFrame implements Runnable {
        
    private boolean a;
    private boolean d;
    private boolean left;
    private boolean right;
    private boolean fimJogo;
    private boolean keyRestart;
    private boolean skill;
    private long ultimaskill;
    private int p1=0;
    private int p2=0;
    
    
     public FrmJogo() 
     {
        initComponents();
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }

     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }else if((evt.getKeyCode() == KeyEvent.VK_A)) {
            a = false ;
        }else if((evt.getKeyCode() == KeyEvent.VK_D)) {
            d = false ;
        }else if (evt.getKeyCode() == KeyEvent.VK_R) {
            keyRestart = false;
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }else if((evt.getKeyCode() == KeyEvent.VK_A)) {
            a = true ;
        }else if((evt.getKeyCode() == KeyEvent.VK_D)) {
            d = true ;
        }else if (evt.getKeyCode() == KeyEvent.VK_R) {
            keyRestart = true;
        }
    }//GEN-LAST:event_formKeyPressed

    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJogo().setVisible(true);
            }
        });
    }
    
    @Override
    public void run() 
    {
        Graphics g;
        ArrayList<Base> lista = new ArrayList();
        ArrayList<Base> lixo = new ArrayList();
        
        
        
        Moldura mold = new Moldura();
        mold.setAltura(295);
        mold.setLargura(395);
        mold.setX(10);
        mold.setY(35);
        mold.setCor(Color.BLACK);
        lista.add(mold);

        Rede rede = new Rede();
        rede.setAltura((getHeight()/4));
        rede.setLargura(10);
        rede.setX(getWidth()/2);
        rede.setY(getHeight()-rede.altura);
        rede.setCor(Color.BLACK);
        lista.add(rede);
        
        Player player = new Player();
        player.setLargura(30);
        player.setAltura(80);
        player.setIncY(0);
        player.setIncX(0);
        player.setX(40);
        player.setY(getHeight() - player.getAltura());
        player.setCor(Color.red);
        lista.add(player);
        
        Player player2 = new Player();
        player2.setLargura(30);
        player2.setAltura(80);
        player2.setIncY(0);
        player2.setIncX(0);
        player2.setX(getWidth() - 100);
        player2.setY(getHeight() - player2.getAltura());
        lista.add(player2);
        
        
       /* Random r = new Random();
        Bola bol = new Bola("img/bola.png");
        bol.setY(mold.getY()-40);
        bol.setX(r.nextInt((mold.getX())));
        lista.add(bol);*/
       
        Random r = new Random();
        Bol bol = new Bol();
        bol.setLargura(40);
        bol.setAltura(40);
        bol.setY(mold.getY()-40);
        bol.setX(r.nextInt((mold.getX())));
        bol.setCor(Color.GREEN);
        lista.add(bol);
        
        
        while (true) {
            g = getBufferStrategy().getDrawGraphics();
            //Limpa a tela
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            
            
            g.setColor(Color.BLACK);
            g.drawString("Pontos P1 ="+ " " + p1, 10,50);
            
            g.setColor(Color.BLACK);
            g.drawString("Pontos P2 =" +" " + p2, 320,50);
            //colisões
            for (Base b : lista) {
                //colisao player e rede com a bola
                if(b == bol)
                {
                if (player.colisao(b)) { 
                    b.setIncY(-1);
                    b.setIncX(1);
                }else if (player2.colisao(b)){
                    b.setIncY(-1);
                    b.setIncX(-1);
                    
                }else if (bol.getY() > player.getY()){
                    if(bol.getX()> getWidth()/2)
                        p1++;
                    else
                        p2++;
                    lixo.add(b);
                }
              }
                
                //colisao rede
                if(b == rede)
                {
                    //player 1 colidindo com a rede
                    if(player.colisao(b))
                    {
                       player.setIncX(-1);
                    }
                    //player 2 colidindo com a rede
                    else if (player2.colisao(b))
                    {
                        player2.setIncX(+1);
                    }
                    
                    if(bol.colisao(b) && bol.getX()< (getWidth()/2) ){
                        bol.setIncX(-1);
                        bol.setIncY(+1);
                    }else if (bol.colisao(b) && bol.getX()> (getWidth()/2) ){
                        bol.setIncX(+1);
                        bol.setIncY(+1);
                    }else if (bol.colisao(b) && bol.getX() == (getWidth()/2) )
                        bol.setIncY(+1);
                        
                }
                
                if ( b == mold )
                {
                  if(player.getX() == 10 ){
                    if(player.colisao(b))
                    {
                       player.setIncX(+1);
                    }
                  }
                  if(player2.getX() == 375){
                    if(player2.colisao(b))
                    {
                        player2.setIncX(-1);
                    }
                  }
                }
                
            }
            
            //desenha os objetos da lista
            for (Base b : lista) {
                b.desenhar(g);
            }
            
            //move os objetos da lista se for diferente de rede
            for (Base b : lista) {
                if(b != rede && b != mold)
                b.mover();
            }
            
            //Se a bola colidir com o chão é adicionada na lista lixo
            for (Base b : lista) {
               
                Colisao aux = b.trataColisao(getWidth(), getHeight());
                if (aux == Colisao.DOWN) {
                    if(bol.getX() > getWidth()/2)
                        p2++;
                    else
                        p1++;
                    lixo.add(b);
                }
            }
            
            
            //limpa toda a lista lixo
            lista.removeAll(lixo);
            lixo.clear();
            
              if (lista.size() == 4) {
                g.setColor(Color.RED);
                g.drawString("FIM de JOGO - Tecle R para Reiniciar", 100, 100);
                fimJogo = true;
            }

            if (fimJogo && keyRestart) {
                
                        bol.setLargura(40);
                         bol.setAltura(40);
                         bol.setY(mold.getY()-40);
                          bol.setX(r.nextInt((mold.getX())));
                         bol.setCor(Color.GREEN);
                            lista.add(bol);
                        
                
                fimJogo = false;
            }
            
            
            //movimento player 1
            if (left) {
                player.setIncX(-1);
            } else {
                if (right) {
                    player.setIncX(1);
                } else {
                    player.setIncX(0);
                }
            }
            
             //movimento player 2
            if (a) {
                player2.setIncX(-1);
            } else {
                if (d) {
                    player2.setIncX(1);
                } else {
                    player2.setIncX(0);
                }
            }
            
            g.dispose();
            getBufferStrategy().show();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
     
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}