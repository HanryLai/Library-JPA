package server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;


public class Server {
    public static void main(String[] args) throws NamingException, RemoteException {
        String url = "rmi://DESKTOP-7L4NA8U:6361/";
        Context context = new InitialContext();



//    PositionService positionDao = new PosionImpl();
//        TaiKhoanImpl daoTK = new TaiKhoanImpl(TaiKhoan.class);
//
//        LocateRegistry.createRegistry(6361);
//
//        context.bind(url + "TKdao",daoTK );




        System.out.println("Server is runing");
    }
}
