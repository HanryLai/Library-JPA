package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client_Dao.Dao_Package_Static;
import gui.FrmLogin;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://192.168.3.48:7878/";
        
        Dao_Package_Static.init(url);
        
        FrmLogin frmLogin = new FrmLogin();
    }
}
