import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {

    staticFileLocation("/public");

    get("/", (request, response) -> {
      return render(new HashMap(), "templates/hello.vm");
    });

    get("/favorite_photos", (request, response) -> {
      return render(new HashMap(), "templates/favorite_photos.vm");
    });
  }

  public static String render(HashMap model, String templatePath) {
    return new VelocityTemplateEngine().render(
      new ModelAndView(model, templatePath)
    );
  }
}
