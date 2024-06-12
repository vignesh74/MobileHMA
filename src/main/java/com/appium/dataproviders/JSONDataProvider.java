/**
 * JSONDataProvider-This class contains the JSON data provider method with json file name Date-24/11/2022
 */

package com.appium.dataproviders;
import java.io.IOException;
import java.io.InputStream;

import com.appium.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONDataProvider {

    /**
     * getJSONObject-This method returns the json object with parameter as json file name
     *
     * @param jsonFileName-String
     * @return-JSONObject
     */
    public JSONObject getJSONObject(String jsonFileName) {
        JSONObject jsonObject;
        InputStream datais = null;
        try {
            datais = getClass().getClassLoader().getResourceAsStream(jsonFileName);
            assert datais != null;
            JSONTokener tokener = new JSONTokener(datais);
            jsonObject = new JSONObject(tokener);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting JSON Object...{}", e.getMessage());
            throw e;
        } finally {
            if (datais != null) {
                try {
                    datais.close();
                } catch (IOException e) {
                    TestUtils.log().debug("Exception occurred");
                }
            }
        }
        return jsonObject;
    }

}
