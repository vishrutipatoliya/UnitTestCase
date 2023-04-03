package com.test.testcasedemo.service;

import com.test.testcasedemo.dto.ProductResponseDTO;
import com.test.testcasedemo.dto.ProductRequestDTO;
import com.test.testcasedemo.entity.Product;
import com.test.testcasedemo.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceimpl implements ProductService {
    // @Autowired
//  private ProductRepo productRepo;
    private final ProductRepo productRepo;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductResponseDTO save(ProductRequestDTO productReuestDTO) {
        Product product = this.productRepo.save(modelMapper.map(productReuestDTO, Product.class));
        return modelMapper.map(product, ProductResponseDTO.class);

    }

    public Product searchById(int id) {

        return productRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> list = productRepo.findAll();
        System.out.println("product" + list);
        return list.stream().map(this::mapToResponseProductDto).collect(Collectors.toList());
    }

    public ProductResponseDTO mapToResponseProductDto(Product product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO findProduct(int id) {

        return modelMapper.map(this.searchById(id), ProductResponseDTO.class);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);

    }


    @Override
    public ProductResponseDTO update(ProductRequestDTO productReuestDTO, int id) {
        Product product = this.searchById(id);

        product.setProductName(product.getProductName());
        product.setBrand(product.getBrand());
        product.setQty(product.getQty());
        product.setPrice(product.getPrice());
        product = productRepo.save(product);

        return modelMapper.map(product, ProductResponseDTO.class);
    }
}
