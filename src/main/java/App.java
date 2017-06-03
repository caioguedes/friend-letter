import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {

  public static void main(String[] args) {

    staticFileLocation("/public");
    String layout = "templates/layout.vm";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hello.vm");
      return render(model, layout);
    });

    get("/favorite_photos", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/favorite_photos.vm");
      return render(model, layout);
    });
    
    get("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vm");
      return render(model, layout);
    });

    get("/greeting_card", (request, response) -> {

      Map<String, Object> model = new HashMap<String, Object>();
      String recipient = request.queryParams("recipient");
      String sender = request.queryParams("sender");

      model.put("recipient", recipient);
      model.put("sender", sender);
      model.put("template", "templates/greeting_card.vm");

      return render(model, layout);
    });
  }

  public static String render(Map model, String templatePath) {
    return new VelocityTemplateEngine().render(
      new ModelAndView(model, templatePath)
    );
  }
}
