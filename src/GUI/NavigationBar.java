package GUI;

import javax.swing.*;

//Implementation of this class uses JMenuBar.

public class NavigationBar extends JFrame{

    JFrame f = new JFrame();
    f.setVisible(true);
    f.setSize(400,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    
    JMenuBar mb = new JMenuBar();
    JMenu create = new JMenu("Create");
    mb.add(file);
    JMenu change = new JMenu("Change");
    mb.add(change);
    JMenu delete = new JMenu("Delete");
    mb.add(delete);
    JMenu createNew = new JMenu("New Password");
    create.add(createNew);
    JMenu changeCurrent = new JMenu("Current Password");
    change.add(changeCurrent);
    
    
    f.setJMenuBar(mb);
    
    
}
