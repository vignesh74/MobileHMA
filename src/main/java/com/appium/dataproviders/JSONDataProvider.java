/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author -Brijesh Mishra JSONDataProvider-This class contains the JSON data provider method with json file name Date-24/11/2022
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
