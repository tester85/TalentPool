package acl.information.professional.infrastructure.model;

public class CountryRequest {

    String country;
    String region;

    public CountryRequest(String country, String region) {
        this.country = country;
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
