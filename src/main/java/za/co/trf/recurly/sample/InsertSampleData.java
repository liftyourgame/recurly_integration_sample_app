package za.co.trf.recurly.sample;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.trf.recurly.sample.domain.Customer;

/**
 * Provides sample data.
 */
@Component
@Configurable
public class InsertSampleData implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // delay init until context is ready so we can put stuff in the db
        if (event instanceof ContextRefreshedEvent) {
            init();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void init() {
        if (!Customer.findAllCustomers().isEmpty()) {
            // Don't do anything if there is data in the db
            return;
        }

        // Customers
        Customer john = new Customer("John Smith");
        john.persist();

        Customer jane = new Customer("Jane Smith");
        jane.persist();
    }

}
