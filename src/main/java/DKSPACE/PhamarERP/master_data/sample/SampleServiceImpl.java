package DKSPACE.PhamarERP.master_data.sample;


import DKSPACE.PhamarERP.basecrud.AbstractBaseCRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SampleServiceImpl extends AbstractBaseCRUDService<SampleEntity, SampleRepository> implements SampleService {
    protected SampleServiceImpl(SampleRepository repository) {
        super(repository);
    }
}
