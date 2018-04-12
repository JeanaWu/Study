package team.WGZ.ATM.Service;

import team.WGZ.ATM.Person.Client;

public abstract class Service {
     private Client client;

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public abstract String work();
}
