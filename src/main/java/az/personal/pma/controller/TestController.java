package az.personal.pma.controller;

import az.personal.pma.entity.*;
import az.personal.pma.repository.*;
import az.personal.pma.request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private ProductMeasurementRepository productMeasurementRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/addMeasurement")
    public Measurement addMeasurement(@RequestBody Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @PostMapping("/mapMeasurements")
    public Product mapMeasurements(@RequestBody TestRequest request) {
        Product product = productRepository.save(request.getProduct());
        List<ProductMeasurement> productMeasurements = new ArrayList<>();
        for (Measurement measurement : request.getMeasurements()) {
            ProductMeasurement productMeasurement = productMeasurementRepository.
                    findByProduct_IdAndMeasurement_Id(request.getProductId(), request.getMeasurementId());
            if (productMeasurement != null) {
                System.out.println("Bu olcu vahidi artiq teyin edilib!");
                return null;
            }
            productMeasurements.add(new ProductMeasurement(product, measurement));
        }
        productMeasurementRepository.saveAll(productMeasurements);
        return productRepository.save(product);
    }

    @PostMapping("/mapPrices")
    public Product mapPrices(@RequestBody TestRequest request) {
        ProductMeasurement productMeasurement = productMeasurementRepository.
                findByProduct_IdAndMeasurement_Id(request.getProductId(), request.getMeasurementId());
        System.out.println(productMeasurement.getProduct().getName() + productMeasurement.getMeasurement().getName());
        List<ProductPrice> prices = productPriceRepository.saveAll(request.getPrices());
        productMeasurement.setPrices(prices);
        productMeasurementRepository.save(productMeasurement);
        return productRepository.findById(request.getProductId()).get();
    }

}
