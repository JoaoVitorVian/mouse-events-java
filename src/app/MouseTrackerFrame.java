package app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MouseTrackerFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JPanel mousePanel; // painel em que os eventos de mouse ocorreräo
    private final JLabel statusBar; // rötulo que exibe informaqöes de evento    
    // Construtor YouseTrackerFrame configura GUI e 
    // registra handlers de evento de mouse 
    public MouseTrackerFrame() {
        super("Demonstrating Mouse Events");
        {
            mousePanel = new JPanel(); // cria painel 
            mousePanel.setBackground(Color.WHITE); // conhgura cor de fundo 
            add(mousePanel, BorderLayout.CENTER); // adiciona painel ao JFrame 
            statusBar = new JLabel("Mouse outside JPane1");
            add(statusBar, BorderLayout.SOUTH); // adiciona rOtulo ao 
            // cria e registra listener para muse e eventos de noviænto de mouse 
            MouseHandler handler = new MouseHandler();
            mousePanel.addMouseListener(handler);
            mousePanel.addMouseMotionListener(handler);
        }// construtor do MouseTrackerFrame  fim 
 
    }
     private class MouseHandler implements MouseListener, MouseMotionListener {
        // Handlers de evento de MouseListener 

        @Override
        public void mouseClicked(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d %d]",
                    event.getX(), event.getY()));
            mousePanel.setBackground(Color.RED);
        }// fim do método mouseC1icked 
        // trata evento quando mouse é pressionado 

        @Override
        public void mousePressed(MouseEvent event) {
            statusBar.setText(String.format("Pressed at [%d %d]",
            event.getX(), event.getY()));
            mousePanel.setBackground(Color.ORANGE);
        } // fim do método mousePressed 
        // trata o evento quando o muse é liberado 

        @Override
        public void mouseReleased(MouseEvent event) {//Quando o botão for solto.
            statusBar.setText(String.format("Released at [%d %d]",
            event.getX(), event.getY()));
        }// hm do método museReleased 
        // trata evento quando mouse entra na årea 

        @Override
        public void mouseEntered(MouseEvent event) {
            statusBar.setText(String.format("Entered at [%d %d]",
            event.getX(), event.getY()));
            mousePanel.setBackground(Color.GREEN);
        }// fim do método museEntered 

        @Override
        public void mouseExited(MouseEvent event) {
          statusBar.setText("Mouse Outside JPanel");
          mousePanel.setBackground(Color.pink);
        }

        @Override
        public void mouseDragged(MouseEvent event) {//Quando clica e arrasta o mouse,provavelmente terei que usa-lo quando for implementar o desenho.
         statusBar.setText(String.format("Dragged at [%d,%d]",
         event.getX(),event.getY()));
          mousePanel.setBackground(Color.BLACK);
        }

        @Override
        public void mouseMoved(MouseEvent event) {
            statusBar.setText(String.format("Moved at [%d,%d]",
            event.getX(),event.getY()));

        }
     }
     public static void main(String[] args) {
        MouseTrackerFrame f = new MouseTrackerFrame();
       f.setDefaultCloseOperation(EXIT_ON_CLOSE);
       f.setSize(500,400);
       f.setVisible(true);
       
     }
     
}