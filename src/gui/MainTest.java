package gui;

import javax.swing.*;
import java.rmi.RemoteException;

public class MainTest extends javax.swing.JFrame{
    public static void main(String[] args) throws RemoteException {
        JPanel panel ;
        panel = new FrmLapHoaDon();
        panel.setSize(800, 600);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
