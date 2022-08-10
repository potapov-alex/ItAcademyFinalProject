package by.it_academy.final_project.rest_api.utils;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;

public final class GetRequestUtils {

    private GetRequestUtils() {
    }

    @Step("Make request and get response body")
    public static ResponseBody makeRequestAndGetResponseBody(String endpoint,
        Map<String, Object> headers,
        Map<String, Object> params) {
        return given()
            .headers(MapUtils.emptyIfNull(headers))
            .params(MapUtils.emptyIfNull(params))
            .when()
            .get(endpoint)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .getBody();
    }
}
