package by.it_academy.final_project.rest_api.service;

import by.it_academy.final_project.rest_api.model.ProductFacet;
import by.it_academy.final_project.rest_api.utils.GetRequestUtils;
import by.it_academy.final_project.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    public List<String> getNameOfProductType() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/"
            + "sushivesla?sushi_typ[0]=roll&sushi_typ[operation]=union";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null,
            null);
        LOG.info("Response body: {}", responseBody.asString());
        return Collections.singletonList(
            ResponseBodyUtils.getStringJsonValue(responseBody, "products.name_prefix"));
    }

    public List<ProductFacet> getProductFacetItems() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null,
            null);
        LOG.info("Response body: {}", responseBody.asString());
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
            ProductFacet.class);
    }
}
