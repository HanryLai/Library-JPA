package dao.Interface;

import entityJPA.BanBaoCao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BanBaoCao_Dao extends Remote {
    public ArrayList<BanBaoCao> getALLBanBaoCao() throws RemoteException;

    public boolean taoBanBaoCao(BanBaoCao bbc) throws RemoteException;

    public int getMaBBCTheoTen(String tenBBC) throws RemoteException;

    BanBaoCao getBanBaoCaoTheoMa(int maBBC) throws RemoteException;
}
