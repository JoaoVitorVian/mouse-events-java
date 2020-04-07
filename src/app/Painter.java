package app;

import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Painter extends JPanel {
  /**
  *
  */
  private static final long serialVersionUID = 1L;
  private int pointCount = 0;

  private Point[] points = new Point[10000];

  public Painter() {
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent event) {
        if (pointCount < points.length) {
          points[pointCount] = event.getPoint();// localiza o ponto
          pointCount++;
          repaint();
        } // fim do if
      }// fim do metodo dragged
    });// fim da classe interna anonima
  }// fim do construtor Painter

  public void paintComponent(Graphics g) {
    super.paintComponent(g);// limpa a área do desenho
    // desenha todos os pontos no array
    for (int i = 0; i < pointCount; i++) {
      g.fillOval(points[i].x, points[i].y, 4, 4);
    }
  }// fim da classe Painter

  public static void main(final String[] args) {
    JFrame application = new JFrame("A simple paint program");
    Painter painter = new Painter();
    application.add(painter, BorderLayout.CENTER);
    // cria um rótulo e coloca em SOUTH do BorderLayout
    application.add(new JLabel("Drag the Mouse to draw"), BorderLayout.SOUTH);

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.setSize(400, 200);
    application.setVisible(true);

  }
}