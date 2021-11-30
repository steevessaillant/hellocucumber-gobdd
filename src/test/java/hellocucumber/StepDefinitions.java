package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    List<RendezVous> mockResults = new ArrayList<>();
    List<RendezVous> expectedResults = new ArrayList<>();
    private RVManager sut;
    private List<RendezVous> actualResults;
    //background

    @Given("Samiha se connect sur son espace du client")
    public void samiha_se_connect_sur_son_espace_du_client() {

    }


    @Given("{string} est sur son espace client")
    public void est_sur_son_espace_client(String username) {
        sut = new RVManager();
        System.out.println(username + " Is Connected");
    }

    @When("elle rentre {string} comme adress")
    public void elle_rentre_comme_adress(String address) {
        sut.SubmittedAdress = address;
    }

    @And("{string} comme date")
    public void comme_date(String dateRequested) {
        sut.dateRequested = dateRequested;
    }

    @And("lance le recherche")
    public void lance_le_recherche() {
        try {
            //injectez votre objet mock ici
            actualResults = sut.SearchRV(mockResults);
        } catch (Exception e) {
            System.out.println("An error occured , tech info : \n");
            e.printStackTrace();
        }
    }

    @Then("la list est affiche comme suivie")
    public void la_list_est_affiche_comme_suivie(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        //1ere validation
        Assert.assertEquals(this.actualResults.size(), rows.size());


        for (Map<String, String> columns : rows) {

            expectedResults.add(new RendezVous(columns.get("Name"), columns.get("Address"), columns.get("Distance"), columns.get("Date")));
        }
        //2eme validation comparez les 2 tableaux
        AtomicInteger index = new AtomicInteger();
        expectedResults.forEach(entity ->
        {
            assertTrue(entity.Date.toString().equals(actualResults.get(index.get()).Date.toString()));
            assertTrue(entity.Name.toString().equals(actualResults.get(index.get()).Name.toString()));
            assertTrue(entity.Address.toString().equals(actualResults.get(index.get()).Address.toString()));
            assertTrue(entity.Distance.toString().equals(actualResults.get(index.get()).Distance.toString()));
            index.addAndGet(1);
        });
    }

}
