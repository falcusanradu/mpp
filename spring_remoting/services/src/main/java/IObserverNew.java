import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserverNew extends Remote {
    void refreshTable() throws RemoteException;

}
