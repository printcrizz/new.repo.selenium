package stepdefs;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode
import cucumber.api.DataTable
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When
import groovy.json.JsonSlurper
import org.openqa.selenium.JavascriptExecutor
import utils.EnvironmentSettings
import utils.GeneralUtils
import utils.RestUtils;
import utils.SeleniumUtils
import utils.XpathEnum

import javax.naming.Binding;

public class StepDefinitions {
    public SeleniumUtils sel = new SeleniumUtils();
    public RestUtils rest = new RestUtils();
    public  HttpResponse<JsonNode> response;
    public XpathEnum xp = new XpathEnum();
    public GeneralUtils gu= new GeneralUtils()
    public EnvironmentSettings es = new EnvironmentSettings();
    public static String TOKEN
    public static String URL
    public def jsonResponse

    @Given("^Abro el Navegador y me dirijo a \"([^\\\"]*)\"\$")
    void OpenBrowser(String url){
        sel.OpenBrowser(url)
        sel.maximizeBrowser()
        gu.ZoomOut()
        }
    @When("^Lleno el campo \"([^\\\"]*)\" con el siguiente valor \"([^\\\"]*)\"\$")
    void fillValue(String campo, String valor){
        switch (campo){
            case "Sueldo Base":
                gu.ScrollDownToElement(sel.returnDriver(),sel.returnElement(xp.XPATH_SUELDO_BASE))
                sel.sendValuesXpath(xp.XPATH_SUELDO_BASE,valor)
                break
            case "Fonasa/Isapre":
                //gu.ScrollDownToElement(sel.returnDriver(),sel.returnElement(xp.XPATH_TEXTLABEL_UF_ISAPRE))
                sel.sendValuesXpath(xp.XPATH_TEXTLABEL_UF_ISAPRE,valor)
                break
        }
    }
    @And("^Selecciono \"ISAPRE\" en dropDown")
 }
