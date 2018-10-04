package utils

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import cucumber.api.DataTable
import gherkin.formatter.model.DataTableRow
import groovy.json.JsonParser
import groovy.json.JsonSlurper
import groovy.text.GStringTemplateEngine
import groovy.text.SimpleTemplateEngine
import groovy.text.StreamingTemplateEngine
import javafx.beans.binding.SetBinding
import org.apache.groovy.json.internal.JsonFastParser

import java.util.Map;
import java.util.Map.Entry;

class RestUtils {

    Unirest rest = new Unirest();

    EnvironmentSettings env = new EnvironmentSettings()

    static HttpResponse<JsonNode> BindingToJason(DataTable data) throws Exception{
        JsonNode aux = ReadTemplateToJson(data).asJson()
        println("Sending the following request: \n\n"+ReadTemplateToJson(data))
        return aux;
    }

    private static String ReadTemplateToJson(DataTable dt) throws Throwable{
        File fileContents = new File("src/test/resources/templates/dropDownValues.template")
        def binding = createBinding(dt)
        GStringTemplateEngine templateEngine = new GStringTemplateEngine()
        def template = templateEngine.createTemplate(fileContents)
        def response = template.make(binding.variables)
        return response;
    }

    static Binding createBinding(DataTable aux) {
        List<Map<String, String>> list = aux.asMaps(String.class, String.class)
        def newBind = new Binding()
        for (int i = 0; i < list.size(); i++) {
           newBind.setVariable(list.get(i).get("Key"),list.get(i).get("Value").toString())
        }
        return newBind
    }
 }
