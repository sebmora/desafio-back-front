package cl.practica.desafio.mymarket.controller;

import cl.practica.desafio.mymarket.domain.ProductDTO;
import cl.practica.desafio.mymarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // READ
    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> getProduct() {
        return productService.getProduct();
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public String createProduct(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT)
    public String updateProduct(@RequestBody ProductDTO product) {
        return productService.updateProduct(product);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteProduct(@RequestParam String id) {
        return productService.deleteProduct(id);
    }
}
