package com.smit.web;
import com.smit.web.models.Products;
import com.smit.web.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebJdbcApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringWebJdbcApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        ApplicationContext context = app.run(args);

        Products p = context.getBean(Products.class);

        p.setPid(101);
        p.setPname("Puma White Sneakers");
        p.setPprice(2900);

        ProductService service = context.getBean(ProductService.class);
        service.addProduct(p);

        System.out.println("Product Created: " + p);





        System.exit(0);

    }
}
