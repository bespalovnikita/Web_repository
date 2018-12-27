package BeNi;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;

public class Rest {

        @Test
        public void allPersonsJson() throws JSONException {
            Response response = get("http://127.0.0.1:8080/persons");
            JSONArray jsonResponse = new JSONArray(response.asString());
            JSONObject obj = jsonResponse.getJSONObject(0);
            String name = obj.getString("name");
            String surname = obj.getString("surname");
            String patronymic = obj.getString("patronymic");
            Assert.assertEquals(name, "test3");
            Assert.assertEquals(surname, "test3");
            Assert.assertEquals(patronymic, "test3");
            Assert.assertEquals(true,jsonResponse.length()>0);
        }
    @Test
    public void onePersonJson() throws JSONException {
        Response response = get("http://127.0.0.1:8080/persons/1");
        JSONObject obj = new JSONObject(response.asString());
       // JSONObject obj = jsonResponse.getJSONObject(0);
        String name = obj.getString("name");
        String surname = obj.getString("surname");
        String patronymic = obj.getString("patronymic");
        Assert.assertEquals(name, "test2");
        Assert.assertEquals(surname, "test2");
        Assert.assertEquals(patronymic, "test2");

    }
}