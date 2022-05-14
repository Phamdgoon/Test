
package Services;

import java.util.List;
import DAO.ProductManagerment;
import Model.Product;

public class Services {
    public ProductManagerment manager;
    
    public Services() {
        manager = new ProductManagerment();
    }
    public List<Product> getAllProduct() {
        return manager.getAllProduct();
    }
    
    public Product getProductByName(String TenSP) {
        return manager.getProductByName(TenSP);
    }
    
    public Product getProductById(String ID) {
        return manager.getProductById(ID);
    }
    
    public void addProduct(Product product) {
        manager.addProduct(product);
    }
    
    public int deleteProduct(int id) {
        return manager.deleteProduct(id);
    }
    
    public void updateProduct(Product product) {
        manager.updateProduct(product);
    }
    
    public List<String> getIds() {
        return manager.getIds();
    }
}
