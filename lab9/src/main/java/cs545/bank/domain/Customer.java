package cs545.bank.domain;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Customer implements Serializable {
	@Inject
	private String name;

	@Inject
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
