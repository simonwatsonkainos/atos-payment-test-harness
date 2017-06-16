package uk.gov.hmpo.jaxws.services;

import uk.gov.hmpo.models.ThingModel;

import javax.jws.WebService;

@WebService(endpointInterface = "IThingService")
public class ThingService implements IThingService {

    private ThingModel thingModel = ThingModel.getInstance();

    @Override
    public String getThing(int id) {
        return thingModel.getThing(id).getDescription();
    }

    @Override
    public void addThing(String description) {
        thingModel.addThing(description);
    }
}
