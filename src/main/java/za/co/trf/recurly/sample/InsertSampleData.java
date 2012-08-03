package za.co.trf.recurly.sample;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.trf.recurly.sample.domain.User;
import za.co.trf.recurly.sample.domain.UserRole;

/**
 * Provides sample data.
 */
@Component
@Configurable
public class InsertSampleData implements ApplicationListener {

    private final String PASSWORD = "5f4dcc3b5aa765d61d8327deb882cf99"; 

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // Delay init until context is ready so we can put stuff in the db
        if (event instanceof ContextRefreshedEvent) {
            init();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void init() {
        if (!User.findAllUsers().isEmpty()) {
            // Don't do anything if there is data in the db
            return;
        }

        // Users
        User john = new User("John Smith", UserRole.USER, "john-smith@example.com", PASSWORD);
        john.persist();

        User jane = new User("Jane Smith", UserRole.USER, "jane-smith@example.com", PASSWORD);
        jane.persist();

        User administrator = new User("Admin", UserRole.ADMIN, "admin@example.com", PASSWORD);
        administrator.persist();
    }

}
