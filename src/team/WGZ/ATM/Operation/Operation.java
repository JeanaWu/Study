package team.WGZ.ATM.Operation;

import team.WGZ.ATM.Person.Client;

public abstract  class Operation {
  private Client client;
  
  public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public abstract String work() ;
public abstract String record();
}
