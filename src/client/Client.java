package client;

import dao.Interface.TaiKhoanDao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://DESKTOP-7L4NA8U:6361/";
        TaiKhoanDao daoTK = (TaiKhoanDao) Naming.lookup(url + "TKdao");
    }
}
