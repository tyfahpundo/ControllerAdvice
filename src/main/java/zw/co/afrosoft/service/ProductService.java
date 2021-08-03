package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.exceptions.NoDataFoundException;
import zw.co.afrosoft.exceptions.ResourceNotFoundException;
import zw.co.afrosoft.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public static List<Product> list = new ArrayList<Product>();

    static{
        list.add(new Product(1,"beans",23.00));
        list.add(new Product(2,"laptop",24.00));
        list.add(new Product(3,"apple",28.00));
        list.add(new Product(4,"bicycle",29.00));
        list.add(new Product(5,"car",20.00));
    }

    public List<Product> getProducts(){
        if(list.isEmpty()){
            throw new NoDataFoundException("Products Not Found");
        }
        return list;
    }
    public Product getProduct(long id){
        Optional<Product> theProduct = list.stream().filter(p-> p.getId() == id).findFirst();
        if(!theProduct.isPresent()){
            throw new ResourceNotFoundException("Product Not Found for id->"+ id);
        }
        return theProduct.get();
    }
}
