package controllers;

import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;
import java.util.ArrayList;
import java.util.List;

import models.Product;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Hello World!"));
    }

    public Result about() {
        return ok(about.render());
    }

    @Transactional
    public Result products() {

        // Find the products (in the DB) and add to a Product arrayList
        // Calls the find.all() method of Product - from the Model superclass
        // https://www.playframework.com/documentation/2.6.x/JavaEbean#Using-Model-superclass
        List<Product> productsList = Product.find.all();

        // Return the view, passing the product list as a parameter
        return ok(products.render(productsList));
    }

}
