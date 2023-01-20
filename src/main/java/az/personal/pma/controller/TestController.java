package az.personal.pma.controller;

import az.personal.pma.entity.*;
import az.personal.pma.repository.*;
import az.personal.pma.request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired ExchangeRepository exchangeRepository;

    @Autowired
    private ProductMeasurementRepository productMeasurementRepository;

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
        Product product = productRepository.findById(request.getProductId()).get();
        for (Measurement measurement : request.getMeasurements()) {
            ProductMeasurement productMeasurement =
                    productMeasurementRepository.save(new ProductMeasurement(product, measurement));
            product.addMeasurement(productMeasurement);
        }
        return productRepository.save(product);
    }

    @PostMapping("/mapPrices")
    public boolean mapPrices(@RequestBody TestRequest request) {
        ProductMeasurement productMeasurement =
                productMeasurementRepository.findByProduct_IdAndMeasurement_Id(request.getProductId(), request.getMeasurementId());
        Measurement measurement = productMeasurement.getMeasurement();
        List<Price> prices = new ArrayList<>();
        for (Price price : request.getPrices()) {
            price.setMeasurement(measurement);
            prices.add(price);
            measurement.addPrice(price);
        }
        priceRepository.saveAll(prices);
        productMeasurement.setMeasurement(measurement);
        productMeasurementRepository.save(productMeasurement);
        return true;
    }

    @PostMapping("/addExchange")
    public Exchange addExchange(@RequestBody TestRequest request) {
        Currency currency = currencyRepository.findById(request.getCurrencyId()).get();
        Exchange exchange = request.getExchange();
        exchange.setCurrency(currency);
        return exchangeRepository.save(exchange);
    }
}
