package cl.practica.desafio.mymarket.service;

import cl.practica.desafio.mymarket.converters.ProductDTOToProductEntity;
import cl.practica.desafio.mymarket.converters.ProductEntityToProductDTO;
import cl.practica.desafio.mymarket.database.ProductRepository;
import cl.practica.desafio.mymarket.domain.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    //Llamamos al converter
    @Autowired
    private ProductEntityToProductDTO productEntityToProductDTO;
    @Autowired
    private ProductDTOToProductEntity productDTOToProductEntity;
    public List<ProductDTO> getProduct() {
        List<ProductDTO> resultado = new ArrayList<>();

        productRepository.findAll().forEach(productEntity ->
                resultado.add(productEntityToProductDTO.convert(productEntity)));
        return resultado ;
    }

    //Desacoplar
    public String createProduct(ProductDTO product) {
        log.info("Insertando el producto" + product);
        if (productRepository.findById(product.getProductId()).isPresent()){
            return "Este ID de producto ya existe";
        }
        else{
            productRepository.save(productDTOToProductEntity.convert(product));
            return "Producto insertado";
        }
    }

    public String updateProduct(ProductDTO product) {
        if (productRepository.findById(product.getProductId()).isPresent()){
            productRepository.save(productDTOToProductEntity.convert(product));
            return "Producto actualizado";
        }
        else {
            return "No se ha encontrado el producto";
        }

    }

    public String deleteProduct(String productId) {
        if (productRepository.findById(productId).isPresent()){
            productRepository.deleteById(productId);
            return "Producto eliminado";
        }
        else{
            return "No se ha encontrado el producto";
        }
    }
}