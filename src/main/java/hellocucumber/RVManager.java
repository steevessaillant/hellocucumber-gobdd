package hellocucumber;

import java.util.ArrayList;
import java.util.List;

public class RVManager {
    public String SubmittedAdress;
    public String dateRequested;

    public List<RendezVous> SearchRV(List<RendezVous> mock) throws Exception {
        if(SubmittedAdress == null || dateRequested == null)
            throw new Exception("Bad params passed");

        List<RendezVous> returnValue  = new ArrayList<>();
        //do a search to an api later mock for now...
        //mock
        if(mock != null) {
            mock.add(new RendezVous("Dr John", "H1X9I9", "1.6km", "29-09-2021"));
            mock.add(new RendezVous("Dr Iny", "H1A1N9", "1.8km", "29-09-2021"));
            return mock;
        }

        return returnValue;

    }
}
