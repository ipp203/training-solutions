package week12.d04;

import java.util.*;

public class Clients {
    Map<String, Client> clients = new HashMap<>();

    public void addClient(String name, String regNumber) {
        clients.put(regNumber, new Client(name, regNumber));
    }

    public Client findByRegNumber(String regNumber) {
        Client result = clients.get(regNumber);
        if (result == null) {
            throw new IllegalArgumentException("Client not exists");
        }
        return result;
    }


    public List<Client> findByName(String name) {
        List<Client> result = new ArrayList<>();
        Collection<Client> clientsList = clients.values();
        for (Client client : clientsList) {
            if (client.getName().contains(name)) {
                result.add(client);
            }
        }
        return result;
    }
}
