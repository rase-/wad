package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.SampleObject;
import wad.spring.domain.User;
import wad.spring.repository.UserRepository;

@Service
public class ObjectFactoryImpl implements ObjectFactory {
    @Autowired
    UserRepository userRepo;
    
    @Override
    public List<SampleObject> getObjects() {
        List<SampleObject> list = new ArrayList();

        list.add(new SampleObject(true));
        list.add(new SampleObject(false));

        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getStudents() {
        List<User> list = userRepo.findAll();
        return list;
    }
    
}
