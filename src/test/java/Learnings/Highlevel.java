package Learnings;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Highlevel {
    public static void main(String[] args) {
        String s = "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ";
// post, headers contentType, authentication method


        String Responses = RestAssured.given().header("headerName","HeaderValue").contentType(ContentType.JSON).body("")
                .when().post().path("base uri +endpoint path").toString();

      // Response response = new Response(Pojo.class);
//{
//    "glossary": {
//        "title": "example glossary",
//		"GlossDiv": {
//            "title": "S",
//			"GlossList": {
//                "GlossEntry": {
//                    "ID": "SGML",
//					"SortAs": "SGML",
//					"GlossTerm": "Standard Generalized Markup Language",
//					"Acronym": "SGML",
//					"Abbrev": "ISO 8879:1986",
//					"GlossDef": {
//                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
//						"GlossSeeAlso": ["GML", "XML"]
//                    },
//					"GlossSee": "markup"
//                }
//            }
//        }

//        glossary/GlossDiv/GlossList/GlossDef/para
//    }
//}





    }
}
