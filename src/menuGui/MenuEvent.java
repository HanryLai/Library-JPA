package menuGui;

import java.rmi.RemoteException;

public interface MenuEvent {

    public void selected(int index, int subIndex) throws RemoteException;
}
