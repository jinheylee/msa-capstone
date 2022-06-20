package hwmsacapstone.infra;

import hwmsacapstone.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommunicationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Communication>> {

    @Override
    public EntityModel<Communication> process(
        EntityModel<Communication> model
    ) {
        return model;
    }
}
