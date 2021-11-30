package hellocucumber;

import java.util.Objects;

public class RendezVous {

    String Name;
    String Address;
    String Distance;
    String Date;

    @Override
    public boolean equals(Object o) {
        RendezVous that = (RendezVous) o;
        return Objects.equals(Name, that.Name) && Objects.equals(Address, that.Address) && Objects.equals(Distance, that.Distance) && Objects.equals(Date, that.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Address, Distance, Date);
    }



    public RendezVous(String name,String address,String distance,String date){
        this.Name = name;
        this.Address = address;
        this.Distance = distance;
        this.Date = date;
    }

}
