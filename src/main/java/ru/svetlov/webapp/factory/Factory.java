package ru.svetlov.webapp.factory;

import ru.svetlov.webapp.service.ProductInfoService;
import ru.svetlov.webapp.service.impl.ProductInfoServiceImpl;

public class Factory {
    private static final ProductInfoService productInfoService = new ProductInfoServiceImpl();

    public static ProductInfoService getProductInfoService(){
        return productInfoService;
    }
}
