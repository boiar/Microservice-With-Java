package org.boiar.ecommerce.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.boiar.ecommerce.product.request.CreateProductRequest;
import org.boiar.ecommerce.product.request.UpdateProductRequest;
import org.boiar.ecommerce.product.response.ProductResponse;
import org.boiar.ecommerce.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody
            @Valid
            CreateProductRequest request
    ){
        return ResponseEntity.status(201).body(this.productService.create(request));
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @RequestBody
            @Valid
            UpdateProductRequest request,
            @PathVariable("product-id") Long id
    ){
        var result = this.productService.update(request, id);
       return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<ProductResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("{product-id}")
    public ProductResponse getById(
            @PathVariable("product-id") Long id
    ) {
        return productService.getById(id);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("product-id") Long id
    ) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
