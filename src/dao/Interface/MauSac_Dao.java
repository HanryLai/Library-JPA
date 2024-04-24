package dao.Interface;

import entityJPA.MauSac;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MauSac_Dao extends Remote {
    ArrayList<MauSac> getAlltbMauSac() throws RemoteException;

    MauSac getMauSactheoMa(String ma) throws RemoteException;

    MauSac getMauSactheoTen(String ten) throws RemoteException;
}
