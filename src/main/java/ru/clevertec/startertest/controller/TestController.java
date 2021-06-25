package ru.clevertec.startertest.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.logging.starter.config.properties.PointcutProperties;
import ru.clevertec.startertest.Entity.ProductOneDto;
import ru.clevertec.startertest.Entity.ProductTwoDto;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final ModelMapper modelMapper;
    private final PointcutProperties pointcutProperties;



    @GetMapping
    public String getProduct() {

        ProductOneDto productOneDto = new ProductOneDto();
        productOneDto.setName("productOne");
        productOneDto.setColor("yellow");
        productOneDto.setWeight("10");

        System.out.println(productOneDto);

        ProductTwoDto productTwoDto = modelMapper.map(productOneDto, ProductTwoDto.class);

        System.out.println(productTwoDto);

        return productTwoDto.toString();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductTwoDto sendEmail(@RequestBody ProductOneDto productOneDto) {
        System.out.println("=============");
        pointcutProperties.getPointcuts().forEach((pointcut) -> System.out.println(pointcut));
        System.out.println("=============");
        return modelMapper.map(productOneDto, ProductTwoDto.class);
    }
}
