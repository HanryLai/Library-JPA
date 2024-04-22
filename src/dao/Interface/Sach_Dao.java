package dao.Interface;

import entityJPA.Sach;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Sach_Dao extends Remote {
    ArrayList<Sach> getAlltbSach() throws RemoteException;

    void createSach(Sach s) throws RemoteException;

    Sach getSachtheoMa(String ma) throws RemoteException;

    void updateSach(Sach s) throws RemoteException;
}
