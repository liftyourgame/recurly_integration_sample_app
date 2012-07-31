package za.co.trf.recurly.sample.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "customer")
public class Customer {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "account_code")
    private String accountCode;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

}
