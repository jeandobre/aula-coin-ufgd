package domain;

import domain.subdomain1.Service;

public class Facade {

    private Service service;

    public Facade(Service service) {
        this.service = service;
    }
}
