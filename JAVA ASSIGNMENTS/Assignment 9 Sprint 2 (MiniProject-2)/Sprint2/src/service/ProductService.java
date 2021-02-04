package service;
import bean.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductService implements Serializable
{
        ArrayList<Product> al=new ArrayList<Product>(); 
        Product pro[]=new Product[500];
       int i=0,k;
        Product p;
        public int addproduct(int id,String pname,float price)
        {
        	pro[i]=new Product(id,pname,price);
        	al.add(pro[i]);
        	i++;
        	return id;
        }
        
        public Product updateProduct(int id,float price)
    	{    
        	  for(Product j:al)
        	  {
        		  if(id==j.getPid())
        		  {
        			  j.setPrice(price);
        			  p=j;
        		  }
        	  }
        	  return p;
        }
        
        public int deleteProduct(int id)
    	{
        	Iterator<Product> iterator = al.iterator();
        	while(iterator.hasNext()) {
        	   Product next = iterator.next();
        	   if(next.getPid()==id) {
        	       iterator.remove();
        	   }
        	}
        return 1;
        }
    	
    	public ArrayList displayAllProduct()
    	{		
    		return al;
    	}
    	
    	public float retrieveProductPrice(int id) {
    	float price=0;
    	{
    		 for(Product j:al)
       	  {
       		  if(id==j.getPid())
       		  {
       			 price = j.getPrice();
       			 break;
       		  }
       	  }
    	return price;
    	}
    }
}