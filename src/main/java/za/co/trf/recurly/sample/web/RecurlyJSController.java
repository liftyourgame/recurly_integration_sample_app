package za.co.trf.recurly.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.trf.recurly.RecurlyConstants;
import za.co.trf.recurly.js.RecurlyJS;

import java.util.HashMap;

@RequestMapping("/recurly/js/**")
@Controller
public class RecurlyJSController {

    @Autowired
    private RecurlyJS recurlyJS;

    @RequestMapping
    public String index() {
        return "recurly/js/index";
    }

    @RequestMapping("subscribe-to-plan")
    public String subscribeToPlan(Model model) {
        String signature = recurlyJS.sign(new HashMap<String, Object>() {{
            put(RecurlyConstants.JS_PARAM_ACCOUNT, new HashMap<String, Object>() {
                {
                    put(RecurlyConstants.JS_PARAM_ACCOUNT_CODE, "123");
                }
            });
        }});
        model.addAttribute("signature", signature);
        return "recurly/js/subscribe-to-plan";
    }

    @RequestMapping("update-billing-info")
    public String updateBillingInfo(Model model) {
        String signature = recurlyJS.sign(new HashMap<String, Object>() {{
            put(RecurlyConstants.JS_PARAM_ACCOUNT, new HashMap<String, Object>() {
                {
                    put(RecurlyConstants.JS_PARAM_ACCOUNT_CODE, "123");
                }
            });
        }});
        model.addAttribute("signature", signature);
        return "recurly/js/update-billing-info";
    }

    @RequestMapping("one-time-transaction")
    public String oneTimeTransaction() {
        return "recurly/js/one-time-transaction";
    }

    @RequestMapping("terms-and-conditions")
    public String termsAndConditions() {
        return "recurly/js/terms-and-conditions";
    }

}
