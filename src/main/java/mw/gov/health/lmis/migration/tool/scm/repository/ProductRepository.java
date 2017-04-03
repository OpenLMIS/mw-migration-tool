package mw.gov.health.lmis.migration.tool.scm.repository;

import com.healthmarketscience.jackcess.Row;

import org.springframework.stereotype.Repository;

import mw.gov.health.lmis.migration.tool.scm.domain.Product;

@Repository
public class ProductRepository extends BaseRepository<Product> {

  @Override
  String getTableName() {
    return "Product";
  }

  @Override
  Product mapRow(Row row) {
    return new Product(row);
  }

  public Product findByProductId(String productId) {
    return find("strProductID", productId);
  }

  public Product findById(Integer id) {
    return find("Pr_lngProductID", id);
  }

}
