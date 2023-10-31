package org.example;

import org.glassfish.jersey.internal.inject.AbstractBinder;

public class JerseyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bindAsContract(AcmeService.class);
    }

}
