package com.tiostitch.cannonbolt;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {

    ImageIcon cenario = new ImageIcon(getClass().getResource("background/Background.png"));
    ImageIcon progresso = new ImageIcon(getClass().getResource("sprites/CannonBolt_Profile.png"));
    ImageIcon personagem_parado_direito = new ImageIcon(getClass().getResource("animations/Cannonbolt_Stop_Right.gif"));
    ImageIcon personagem_parado_esquerdo = new ImageIcon(getClass().getResource("animations/Cannonbolt_Stop_Left.gif"));
    ImageIcon personagem_movendo = new ImageIcon(getClass().getResource("animations/Cannonbolt_Move.gif"));

    JLabel iPersonagem = new JLabel(personagem_parado_direito);
    JLabel iCenario = new JLabel(cenario);
    JLabel iProgresso = new JLabel(progresso);

    int cannonXpos = 100, cannonYpos = 201;

    public void editarComponentes() {
        iCenario.setBounds(0, 0, 774, 360);
        iPersonagem.setBounds(cannonXpos, cannonYpos, 100, 100);
        iProgresso.setBounds(-175, -55, 596, 214);
    }

    public Main() {
        editarCenario();
        editarComponentes();
        adicionarMovimento();
    }

    public void editarCenario() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(774, 360);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        add(iProgresso);
        add(iPersonagem);
        add(iCenario);
    }

    public void adicionarMovimento() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (e.getKeyCode() == 20) {
                    iPersonagem.setSize(400, 400);
                    iPersonagem.setBounds(cannonXpos, cannonYpos, 200, 200);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 39:
                        if (cannonXpos == 680) {
                            return;
                        }
                        cannonXpos += 10;
                        break;
                    case 37:
                        if (cannonXpos == -20) {
                            return;
                        }
                        cannonXpos -= 10;
                        break;
                }

                if (e.getKeyCode() == 39 || e.getKeyCode() == 37) {
                    iPersonagem.setIcon(personagem_movendo);
                    iPersonagem.setBounds(cannonXpos, cannonYpos, 100, 100);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 39:
                        iPersonagem.setIcon(personagem_parado_direito);
                        break;
                    case 37:
                        iPersonagem.setIcon(personagem_parado_esquerdo);
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
