package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client_Dao.Dao_Package_Static;
import gui.FrmChinh;
import gui.FrmLogin;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://localhost:7878/";
        
        Dao_Package_Static.init(url);
        
        FrmChinh frmLogin = new FrmChinh();
        frmLogin.setVisible(true);
    }
}



