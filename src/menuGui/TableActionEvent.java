package menuGui;

import java.rmi.RemoteException;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onPlus(int row) throws RemoteException;

    public void onDelete(int row) throws RemoteException;

    public void onMinus(int row) throws RemoteException;
}
