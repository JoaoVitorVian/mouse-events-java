  package app;
  import java.awt.event.MouseEvent;
  import javax.swing.*;
  import javax.swing.event.MouseInputAdapter;
  import java.awt.*;


  public class MouseDetailsFrame extends JFrame {
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    private String details;
    private final JLabel statusBar;

    public MouseDetailsFrame() {
      super("Mouse Clicks and buttons");
      statusBar = new JLabel("Click the mouse");
      add(statusBar, BorderLayout.SOUTH);
      addMouseListener(new MouseClickHandler());
    }

    private class MouseClickHandler extends MouseInputAdapter {
    public void mouseClicked(MouseEvent event){
      int xPos = event.getX();
      int yPos = event.getY();
      details = String.format("Clicked %d time(s)",
      event.getClickCount());

      if(event.isMetaDown())//botão direito do mouse
      details +="with right mouse button";
      else if(event.isAltDown())//botão do meio do mouse
      details+="with center mouse button";
      else//botão esquerdo do mouse
      details+="with left mouse button";

      statusBar.setText(details);//exibe mensagem em statusbar
    }
  }
  public static void main(final String[] args) {
    MouseDetailsFrame f = new MouseDetailsFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400,150);
    f.setVisible(true);
    
  }
  }