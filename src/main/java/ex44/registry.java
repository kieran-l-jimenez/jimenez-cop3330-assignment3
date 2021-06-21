package ex44;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class registry {
    product[] goods;
    int numGoods;

    product retrieveProduct(String name)
    {
        product ret = new product();
        for(int i = 0; i < numGoods; i++)
        {
            if(name.equalsIgnoreCase(goods[i].name)) {
                ret = goods[i];
                break;
            } else {
                ret.name = "NotFound";
            }
        }
        return ret;
    }

    registry fillProductArray()
    {
        JSONParser myParser = new JSONParser();
        registry ret = new registry();

        try {
            FileReader myFile = new FileReader("src/main/java/ex44/productList.JSON");

            Object myObject = myParser.parse(myFile);

            JSONObject products = (JSONObject) myObject;

            JSONObject productArray = (JSONObject) products.get("products");


            ret.numGoods = productArray.size();
            ret.goods = new product[ret.numGoods];

            for(int i = 0; i < ret.numGoods; i++)
            {
                //ret.goods[i].name = productArray.get("name").toString();
                //ret.goods[i].price = productArray.get();
                //ret.goods[i].quantity = productArray.get();
            }
            return ret;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ret;
    }

    boolean productFound(product check)
    {
        return !check.name.equalsIgnoreCase("NotFound");
    }
}
