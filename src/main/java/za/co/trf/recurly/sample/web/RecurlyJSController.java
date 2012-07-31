package za.co.trf.recurly.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recurly/js/**")
@Controller
public class RecurlyJSController {

    @RequestMapping
    public String index() {
        return "recurly/js/index";
    }

    @RequestMapping("subscribe-to-plan")
    public String subscribeToPlan() {
        return "recurly/js/subscribe-to-plan";
    }

    @RequestMapping("update-billing-info")
    public String updateBillingInfo() {
        return "recurly/js/update-billing-info";
    }

    @RequestMapping("one-time-transaction")
    public String oneTimeTransaction() {
        return "recurly/js/one-time-transaction";
    }
    

}
