package Utils;

import javax.swing.JPanel;

/**
 *
 * @author mateus
 */
public class JPanelManager {
    
    private JPanel container;
    private JPanel content;
    
    
    public JPanelManager(JPanel container, JPanel content) {
      
        this.container = container;
        this.content = content;  
        this.container.removeAll();    
        this.container.revalidate();
        this.container.repaint();
        this.container.add(content);   
        this.container.revalidate();
        this.container.repaint();            
    }
}
