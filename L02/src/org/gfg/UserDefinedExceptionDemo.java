package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class UserDefinedExceptionDemo {

    List<String> list;
    public UserDefinedExceptionDemo(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<String> productList = new ArrayList<>();
        productList.add("pen");
        productList.add("laptop");
        UserDefinedExceptionDemo userDefinedExceptionDemo = new UserDefinedExceptionDemo(productList);
        try {
            System.out.println(userDefinedExceptionDemo.getProduct("iphone"));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException();
//            System.out.println("Exception : "+e);
        }
        System.out.println("Done");
    }

    public String getProduct(String name) throws ProductNotFoundException {
        boolean found=false;
        String result = null;
        for(String prod : list){
            if(name.equals(prod)){
                found =true;
                result = prod;
            }
        }
        if(!found){
            throw new ProductNotFoundException();
        }
        return result;
    }

}
