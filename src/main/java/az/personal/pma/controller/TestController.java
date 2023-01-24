package az.personal.pma.controller;

import az.personal.pma.entity.*;
import az.personal.pma.repository.*;
import az.personal.pma.request.RecipeRequest;
import az.personal.pma.request.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    private PriceRepository priceRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    ExchangeRepository exchangeRepository;

    @Autowired
    private ProductMeasurementRepository productMeasurementRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RecipeRepository recipeRepository;

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
    public Exchange addExchange(@RequestBody TestRequest request) throws ParseException {
        Currency currency = currencyRepository.findById(request.getCurrencyId()).get();
        Exchange exchange = request.getExchange();
        exchange.setCurrency(currency);
        return exchangeRepository.save(exchange);
    }

    @PostMapping("/addWarehouse")
    public Warehouse addWarehouse(@RequestBody TestRequest request) {
        Branch branch = branchRepository.findById(request.getBranchId()).get();
        Warehouse warehouse = request.getWarehouse();
        warehouse.setBranch(branch);
        return warehouseRepository.save(request.getWarehouse());
    }

    @PostMapping("/addBranch")
    public Branch addBranch(@RequestBody TestRequest request) {
        return branchRepository.save(request.getBranch());
    }

    @GetMapping("/getAllBranch")
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(@RequestBody TestRequest request) {
        ProductMeasurement productMeasurement =
                productMeasurementRepository.findByProduct_IdAndMeasurement_Id(request.getProductId(), request.getMeasurementId());
        if (productMeasurement == null) {
            System.out.println("Bu mehsul ucun bu olcu vahidi teyin edilmeyib");
        }
        Recipe recipe = recipeRepository.save(new Recipe(productMeasurement, request.getQuantity()));
        List<Recipe> recipes = new ArrayList<>();
        for (RecipeRequest recipeRequest : request.getRecipes()) {
            ProductMeasurement raw =
                    productMeasurementRepository.findByProduct_IdAndMeasurement_Id(recipeRequest.getProductId(), recipeRequest.getMeasurementId());
            if (productMeasurement == null) {
                System.out.println("Bu mehsul ucun bu olcu vahidi teyin edilmeyib");
            }
            recipes.add(new Recipe(productMeasurement, recipeRequest.getQuantity(), recipe));
        }
        recipeRepository.saveAll(recipes);
        return recipe;
    }

}
